package co.edu.uptc.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ControllerClient {

    private Socket socket;
    private final int PORT = 49045;
    private final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private boolean connected;

    public ControllerClient() {
        try { 
            socket = new Socket(HOST, PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            connected = true;
            sendMessage("HELLO_SERVER");
            System.out.println("Conectado al servidor");
        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }

    public void sendMessage(String message) throws IOException {
        if (connected) {
            output.writeUTF(message);
            output.flush();
        } else {
            System.out.println("⚠️ No estás conectado al servidor");
        }
    }

    public String receiveMessage() throws IOException {
        if (connected) {
            return input.readUTF();
        }
        return null;
    }

    public void disconnect() {
        try {
            connected = false;
            if (input != null) input.close();
            if (output != null) output.close();
            if (socket != null) socket.close();
            System.out.println("🔌 Conexión cerrada correctamente");
        } catch (IOException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

    public boolean isConnected() {
        return connected;
    }
}
