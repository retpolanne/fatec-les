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
            boolean disabled = false;
            while(true) {
                String inLine = this.in.readLine();
                System.out.println(inLine);
                if (inLine.equals("[ATTACK DISABLED]")) {
                    this.out.println("The attack has been disabled");
                    disabled = true;
                }
                if (inLine.equals("[UNLOCK SYSTEM]")) {
                    if (disabled) {
                        this.out.println("The system has been unlocked");
                        break;
                    } else {
                        this.out.println("System not unlocked!");
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
            this.serverSocket.close();
            System.out.println("Closed resources");
        } catch (IOException e) {
            System.out.println("Error closing resources");
            e.printStackTrace();
        }
    }
}