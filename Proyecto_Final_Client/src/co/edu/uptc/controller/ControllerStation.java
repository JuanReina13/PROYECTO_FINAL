package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;

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
                        if (command.equals("NEW_ORDER")) {
                            String json = input.readUTF();
                            Order order = gson.fromJson(json, Order.class);
                            System.out.println("📥 Nueva orden recibida en " + stationName + ": " + order.getIdOrder());
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

    public void stop() {
        try {
            running = false;
            socket.close();
        } catch (Exception ignored) {}
    }
}

