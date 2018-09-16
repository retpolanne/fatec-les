package view;

import controller.ClientController;;

public class Socket {
    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        int keepAlive = Integer.parseInt(args[2]);
        System.out.println(
            "Creating socket and connecting to  " + host +
            " at port " + port
        );
        ClientController clientController = new ClientController(host, port);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                clientController.closeResources();
            }
        }));
        clientController.ioController(keepAlive);
    }
}