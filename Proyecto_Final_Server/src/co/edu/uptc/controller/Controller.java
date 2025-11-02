package co.edu.uptc.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.uptc.model.RestaurantManager;


public class Controller {

    private final int PORT  = 49045;// Toca pedirlo por View
    private ServerSocket serverSocket;
    private RestaurantManager restaurantManager;

    public Controller() throws IOException {
        restaurantManager = new RestaurantManager();
        serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            new ClientsThread(socket, restaurantManager).start();
        }
    }
}

