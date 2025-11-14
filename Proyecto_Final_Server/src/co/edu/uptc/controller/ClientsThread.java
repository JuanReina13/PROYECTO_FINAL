package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;

import co.edu.uptc.model.Order;
import co.edu.uptc.model.RestaurantManager;
import co.edu.uptc.model.Station;

public class ClientsThread extends Thread {

    private Socket socket;
    private DataOutputStream dataOutput;
    private DataInputStream dataInput;
    private RestaurantManager restaurantManager;
    private Gson gson = new Gson();

    public ClientsThread(Socket socket, RestaurantManager restaurantManager) {
        this.socket = socket;
        this.restaurantManager = restaurantManager;
    }

    @Override
    public void run() {
        try {
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataInput = new DataInputStream(socket.getInputStream());
            System.out.println("✅ Cliente conectado: " + socket.getInetAddress());

            boolean running = true;

            while (running) {
                String command = dataInput.readUTF();
                System.out.println("📩 Comando recibido: " + command);

                switch (command) {
                    case "NEW_ORDER":
                        String orderJson = dataInput.readUTF();
                        System.out.println("📦 JSON recibido: " + orderJson);
                        Order order = gson.fromJson(orderJson, Order.class);
                        restaurantManager.addOrder(order);
<<<<<<< HEAD
                        System.out.println("✅ Orden agregada: " + order.getIdOrder());
                        break;

                    case "GET_ORDERS":
                        String stationName2 = dataInput.readUTF();
                        Station station2 = restaurantManager.findStationByName(stationName2);

                        List<Order> activeOrders = restaurantManager.getActiveOrdersForStation(station2);
                        String ordersJson = gson.toJson(activeOrders); // ✅ Serializar aquí

                        dataOutput.writeUTF("ORDERS");
                        dataOutput.writeUTF(ordersJson);
                        dataOutput.flush();
                        System.out.println("✅ Enviadas " + activeOrders.size() + " órdenes a " + stationName2);
=======
                        dataOutput.writeUTF("Orden recibida correctamente");
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)
                        break;

                    case "GET_HISTORY":
                        String historyJson = gson.toJson(restaurantManager.getRecordsJson());

                        dataOutput.writeUTF("HISTORY");
                        dataOutput.writeUTF(historyJson);
                        dataOutput.flush();
                        System.out.println("📜 Historial enviado (" + historyJson.length() + " bytes)");
                        break;

                    case "FINISH_ORDER":
                        String finishOrderJson = dataInput.readUTF();
                        Order finishOrder = gson.fromJson(finishOrderJson, Order.class);
                        restaurantManager.finishOrder(finishOrder);
                        System.out.println("✅ Orden finalizada: " + finishOrder.getIdOrder());
                        break;

                    case "REGISTER_STATION":
                        String stationName = dataInput.readUTF();
                        Station station = restaurantManager.findStationByName(stationName);

                        if (station != null) {
                            station.setClientOutput(dataOutput);

                            List<Order> initialOrders = restaurantManager.getActiveOrdersForStation(station);
                            String initialJson = gson.toJson(initialOrders);

                            dataOutput.writeUTF("ORDERS");
                            dataOutput.writeUTF(initialJson);
                            dataOutput.flush();
                            System.out.println("✅ Estación registrada: " + stationName + " con " + initialOrders.size()
                                    + " órdenes");
                        } else {
                            System.out.println("⚠️ Estación no encontrada: " + stationName);
                        }
                        break;

                    case "EXIT":
                        running = false;
                        System.out.println("👋 Cliente solicita desconexión");
                        break;

                    default:
                        System.out.println("⚠️ Comando desconocido: " + command);
                        break;
                }
            }

            socket.close();
            System.out.println("🔌 Cliente desconectado: " + socket.getInetAddress());

        } catch (Exception e) {
            System.out.println("❌ Error en hilo cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
