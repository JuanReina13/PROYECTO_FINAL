package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Order;
import co.edu.uptc.model.Product;
import co.edu.uptc.view.stations.OrderCardPanel;
import co.edu.uptc.view.stations.RecordPanel;
import co.edu.uptc.view.stations.ViewStation;

import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SwingUtilities;

public class ControllerStation {
    private final String HOST = "localhost";
    private final int PORT = 49045;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private Gson gson;
    private boolean running;
    private String stationName;
    private ViewStation viewStation;
    private List<Order> orderList;
    private List<Order> orderHistory;

    public ControllerStation(String stationName) {
        this.stationName = stationName;
        orderList = new ArrayList<>();
        orderHistory = new ArrayList<>();
        gson = new Gson();
    }

    public void start() {
        try {
            socket = new Socket(HOST, PORT);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            output.writeUTF("REGISTER_STATION");
            output.writeUTF(stationName);

            running = true;
            new Thread(() -> {
                try {
                    while (running) {
                        String command = input.readUTF();
                        switch (command) {
                            case "NEW_ORDER":
                                String json = input.readUTF();
                                Order order = gson.fromJson(json, Order.class);
                                orderList.add(order);
                                SwingUtilities.invokeLater(() -> {
                                    if (viewStation != null) {
                                        viewStation.getInfoPanel().addOrderCount();
                                        List<String> productStrings = new ArrayList<>();
                                        for (Product p : order.getProducts()) {
                                            productStrings.add(p.getQuantity() + "x " + p.getName());
                                        }
                                        OrderCardPanel card = new OrderCardPanel(order.getIdOrder(), order.getTable(),
                                                String.format("%02d:%02d", LocalTime.now().getHour(),
                                                        LocalTime.now().getMinute()),
                                                productStrings, true);
                                    }
                                });
                                break;

                            case "ORDER_FINISHED":
                                String finishedOrderJson = input.readUTF();
                                Order finishedOrder = gson.fromJson(finishedOrderJson, Order.class);
                                orderList.removeIf(o -> o.getIdOrder().equals(finishedOrder.getIdOrder()));
                                viewStation.getInfoPanel().removeOrderCount();

                                break;
                            case "HISTORY":
                                String historyJson = input.readUTF();
                                Order[] orders = gson.fromJson(historyJson, Order[].class);
                                orderHistory.clear();
                                orderHistory.addAll(Arrays.asList(orders));
                                System.out.println("📜 Historial recibido: " + orderHistory.size() + " órdenes");
                                SwingUtilities.invokeLater(() -> {
                                    if (viewStation != null) {
                                        viewStation.showHistoryPanel();
                                    }
                                });
                                break;
                            case "EXIT":
                                running = false;
                                stop();
                                break;
                            default:
                                break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Conexión cerrada para " + stationName);
                }
            }).start();

        } catch (Exception e) {
            System.out.println("Error al conectar estación: " + e.getMessage());
        }
    }

    public void sendFinishOrder(Order order) {
        try {
            output.writeUTF("FINISH_ORDER");
            output.writeUTF(gson.toJson(order));
            output.flush();
            System.out.println("✅ Solicitud de finalización enviada: " + order.getIdOrder());
        } catch (IOException e) {
            System.out.println("Error al enviar FINISH_ORDER: " + e.getMessage());
        }
    }

    public void sendFinishOrderById(String orderId) {
        orderList.stream()
                .filter(o -> o.getIdOrder().equals(orderId))
                .findFirst().ifPresent(this::sendFinishOrder);
    }

    public void requestHistory() {
        try {
            output.writeUTF("GET_HISTORY");
            output.flush();
        } catch (IOException e) {
            System.out.println("Error al solicitar el historial: " + e.getMessage());
        }
    }

    public void stop() {
        try {
            running = false;
            socket.close();
        } catch (Exception ignored) {
        }
    }

    public void setViewStation(ViewStation viewStation) {
        this.viewStation = viewStation;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}
