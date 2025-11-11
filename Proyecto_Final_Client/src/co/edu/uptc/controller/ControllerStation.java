package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.gson.Gson;

import co.edu.uptc.model.Order;

import java.net.Socket;

public class ControllerStation {
    private final String HOST = "localhost";
    private final int PORT = 49045;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private Gson gson;
    private boolean running;
    private String stationName;

    public ControllerStation(String stationName) {
        this.stationName = stationName;
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
                                
                                break;

                            case "ORDER_FINISHED":
                                String finishedOrderJson = input.readUTF();
                                Order finishedOrder = gson.fromJson(finishedOrderJson, Order.class);

                                break;
                            case "HISTORY":
                                String historyJson = input.readUTF();
                                Order[] orders = gson.fromJson(historyJson, Order[].class);

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

    public void stop() {
        try {
            running = false;
            socket.close();
        } catch (Exception ignored) {
        }
    }
}
