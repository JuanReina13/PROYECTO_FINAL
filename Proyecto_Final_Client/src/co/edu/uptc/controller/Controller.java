package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Order;
import co.edu.uptc.model.ProductCategory;

public class Controller {

    private static final String HOST = "localhost";
    private static final int PORT = 49045;
    private DataOutputStream dataOutput;
    private DataInputStream dataInput;
    private Gson gson = new Gson();

    public Controller() {
        try (Socket socket = new Socket(HOST, PORT)) {
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataInput = new DataInputStream(socket.getInputStream());
            sendNewOrder(new Order("Paw Paw", List.of(
                    new co.edu.uptc.model.Product("bbq chiken gouda onion Pizza", ProductCategory.PIZZA, 15.99, 1),
                    new co.edu.uptc.model.Product("Chef Salad", ProductCategory.SALAD, 7.99, 1),
                    new co.edu.uptc.model.Product("chicago dog", ProductCategory.HOT_DOG, 8.49, 2)
                    )));
                    System.out.println("Order created and sent to server.");
            requestHistory();
            sendExit();
        } catch (IOException e) {
            System.out.println("Error en cliente: " + e.getMessage());
        }
    }

    private void sendNewOrder(Order order) throws IOException {
        dataOutput.writeUTF("NEW_ORDER");
        dataOutput.writeUTF(gson.toJson(order));
        System.out.println("Respuesta del servidor: " + dataInput.readUTF());
    }

    private void requestHistory() throws IOException {
        dataOutput.writeUTF("GET_HISTORY");
        String json = dataInput.readUTF();
        List<Order> orders = gson.fromJson(json, new TypeToken<List<Order>>() {}.getType());
        System.out.println("\n📜 Historial recibido del servidor:");
        orders.forEach(System.out::println);
    }

    private void sendExit() throws IOException {
        dataOutput.writeUTF("EXIT");
    }

}
