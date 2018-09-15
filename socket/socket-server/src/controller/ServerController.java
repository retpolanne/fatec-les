package controller;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class ServerController {
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private InputStream in;
    private OutputStream out;

    public ServerController (int port) {
        this.port = port;
        this.createSocketServer(port);
    }

    private void createSocketServer (int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Created socket server on port " + port);
        } catch (IOException e) {
            System.out.println("Could not create the socket server");
            e.printStackTrace();
        }
    }

    private void getIO () {
        try {
            this.socket = this.serverSocket.accept();
            this.in = this.socket.getInputStream();
            this.out = this.socket.getOutputStream();
            System.out.println("Socket server is accepting connections...");
        } catch (IOException e) {
            System.out.println("Error getting IO from socket");
            e.printStackTrace();
        }
        
    }

    public void ioController() {
        try {
            this.getIO();
            this.out.write("Connected to server - hit ^C to end\r\n".getBytes());
            this.out.flush();
            while(true) {
                while(this.in.available() > 0) {
                    System.out.println((char) this.in.read());
                }
            }
        } catch (IOException e) {
            System.out.println("Error getting using IO");
            e.printStackTrace();
        }
        
    }

    public void closeResources() {
        try {
            this.in.close();
            this.out.close();
            this.socket.close();
            this.serverSocket.close();
            System.out.println("Closed resources");
        } catch (IOException e) {
            System.out.println("Error closing resources");
            e.printStackTrace();
        }
    }
}