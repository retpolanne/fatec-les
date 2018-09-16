package iohelper.strategies;

import iohelper.interfaces.IOStrategy;

import java.io.File;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketIOStrategy implements IOStrategy<Socket> {
    private BufferedReader inputReader;
    private PrintWriter outputWriter;

    public void createReader (Socket socket) throws IOException {
        this.inputReader = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );
    }
    public void createWriter (Socket socket) throws IOException {
        this.outputWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public String readLine () throws IOException {
        if (this.inputReader.read() < 0) {
            System.out.println("Connection closed by foreign host.");
            return null;
        }
        return this.inputReader.readLine();
    }

    public List<String> readWhole () throws IOException {
        String line;
        List<String> lines = new ArrayList<String>();
        while (true) {
            line = this.inputReader.readLine();
            if (line == null || line.isEmpty())
                break;
            lines.add(line);
        }
        return lines;
    }

    public void write (String message, boolean append) throws IOException {
        this.outputWriter.println(message);
    }

    public void closeReader () throws IOException {
        this.inputReader.close();
    }

    public void closeWriter () throws IOException {
        this.outputWriter.close();
    }
}