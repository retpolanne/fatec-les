package view;

import java.net.Socket;
import java.io.IOException;
import iohelper.contexts.IOContext;
import iohelper.strategies.SocketIOStrategy;

public class Main {
    public static void main (String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
    
        try {
            Socket socket = new Socket(host, port);
            IOContext ioContext = new IOContext(socket);
            ioContext.setIOStrategy(new SocketIOStrategy());
            ioContext.attachIO(true);
            ioContext.write("GET", false);
            System.out.println(ioContext.readWhole());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}