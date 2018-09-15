package view;

import controller.ServerController;;

public class Socket {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        System.out.println("Creating socket server listening on port " + port);
        ServerController serverController = new ServerController(port);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                serverController.closeResources();
            }
        }));
        serverController.ioController();
    }
}