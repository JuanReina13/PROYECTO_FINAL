package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.google.gson.Gson;

import co.edu.uptc.model.Order;
import co.edu.uptc.model.RestaurantManager;

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
            System.out.println("Cliente conectado: " + socket.getInetAddress());

            boolean running = true;

            while (running) {
                String command = dataInput.readUTF();

                switch (command) {
                    case "NEW_ORDER":
                        String orderJson = dataInput.readUTF();
                        Order order = gson.fromJson(orderJson, Order.class);
                        restaurantManager.addOrder(order);
                        dataOutput.writeUTF("Orden recibida correctamente");
                        
                        break;

                    case "GET_HISTORY":
                        String historyJson = restaurantManager.getOrdersJson();
                        dataOutput.writeUTF(historyJson);
                        break;

                    case "EXIT":
                        running = false;
                        break;

                    default:
                        dataOutput.writeUTF("Comando no reconocido");
                }
            }

            socket.close();
            dataOutput.close();
            dataInput.close();
            System.out.println("Cliente desconectado: " + socket.getInetAddress());

        } catch (Exception e) {
            System.out.println("Error en hilo cliente: " + e.getMessage());
        }
    }
}

