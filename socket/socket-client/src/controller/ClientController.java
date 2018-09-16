package controller;

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

    public void ioController(int keepAlive) {
        try {
            this.getIO();
            System.out.println("Connected to server - type quit to end");
            String serverIn;
            int connectionStatus;
            boolean ready;
            while (true) {
                this.out.println(this.stdIn.readLine());
                while (!this.in.ready())
                    // Don't know why readLine blocks and hangs, so I have to do something here
                    ready = true;
                while (this.in.ready()) {
                    serverIn = this.in.readLine();
                    System.out.println(serverIn);
                }
                if (keepAlive == 0) {
                    if ((connectionStatus = this.in.read()) < 0) {
                        System.out.println("Connection closed by foreign host.");
                        break;
                    }
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
            System.out.println("Closed resources");
        } catch (IOException e) {
            System.out.println("Error closing resources");
            e.printStackTrace();
        }
    }
}