package controller;

import java.net.ConnectException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ClientController {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private BufferedReader stdIn;
    private PrintWriter out;

    public ClientController (String host, int port) {
        this.host = host;
        this.port = port;
        this.createSocket(host, port);
    }

    private void createSocket (String host, int port) {
        try {
            this.socket = new Socket(host, port);
            System.out.println(
                "Created socket server on host " + host + 
                " and port " + port
            );
        } catch (ConnectException e) {
            System.out.println("Connection refused, the host may be down");
        } catch (IOException e) {
            System.out.println("Could not create the socket");
            e.printStackTrace();
        }
    }

    private void getIO () {
        try {
            this.in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
            );
            this.stdIn = new BufferedReader(
                new InputStreamReader(System.in)
            );
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            System.out.println("Socket is accepting connections...");
        } catch (IOException e) {
            System.out.println("Error getting IO from socket");
            e.printStackTrace();
        }
        
    }

    public void ioController() {
        try {
            this.getIO();
            System.out.println("Connected to server");
            this.out.println("[ATTACK DISABLED]");
            System.out.println(this.in.readLine());
            this.out.println("[UNLOCK SYSTEM]");
            System.out.println(this.in.readLine());
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
            System.out.println("Closed resources");
        } catch (IOException e) {
            System.out.println("Error closing resources");
            e.printStackTrace();
        }
    }
}