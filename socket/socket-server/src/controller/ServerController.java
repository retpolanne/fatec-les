package controller;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class ServerController {
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;

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
            this.in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
            );
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            System.out.println("Socket server is accepting connections...");
        } catch (IOException e) {
            System.out.println("Error getting IO from socket");
            e.printStackTrace();
        }
        
    }

    public void ioController() {
        try {
            this.getIO();
            //this.out.println("Connected to server - type quit to end");
            this.out.flush();
            while(true) {
                String inLine = this.in.readLine();
                System.out.println(inLine);
                this.out.println("echo: " + inLine);
                if (inLine.equals("quit"))
                    break;
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