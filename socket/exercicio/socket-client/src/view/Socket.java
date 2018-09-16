package view;

import controller.ClientController;;

public class Socket {
    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.println(
            "Creating socket and connecting to  " + host +
            " at port " + port
        );
        try {
            ClientController clientController = new ClientController(host, port);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                public void run() {
                    clientController.closeResources();
                }
            }));
            clientController.ioController();
        } catch (Exception e) {
            return;
        }
    }
}