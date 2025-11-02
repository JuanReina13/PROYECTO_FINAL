package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import co.edu.uptc.model.RestaurantManager;

public class ClientsThread extends Thread {

    private Socket socket;
    private DataOutputStream dataOutput;
    private DataInputStream dataInput;
    private RestaurantManager restaurantManager;

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
                        // Aquí podrías leer un objeto o cadena JSON con los datos
                        // y crear la orden en el modelo
                        break;

                    case "FINISH_ORDER":
                        // Leer ID de la orden a finalizar
                        break;

                    case "GET_HISTORY":
                        // Enviar historial al cliente
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

