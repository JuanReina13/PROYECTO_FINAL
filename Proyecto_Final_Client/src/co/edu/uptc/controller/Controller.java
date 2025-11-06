package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {

    private Socket socket;
    private final int PORT = 45049;
    private final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;

    public Controller() {
        try { 
            socket = new Socket(HOST, PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
    
            System.out.println("Conectado al servidor");
        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
