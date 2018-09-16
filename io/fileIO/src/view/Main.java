package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.IOController;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        BufferedReader userReader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        IOController ioController = new IOController(filePath);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                ioController.closeResources();
            }
        }));
        String userIn;
        System.out.println("Type quit to exit and read to read file");
        try {
            while (true) {
                userIn = userReader.readLine();
                if (userIn.equals("quit"))
                    break;
                if (userIn.equals("read")) {
                    System.out.println("Reading file");
                    ioController.readFile();
                } else {
                    ioController.writeFile(userIn);
                }
            }
        } catch (IOException e) {
            System.out.println("Error getting user input");
            e.printStackTrace();
        }
    }
}