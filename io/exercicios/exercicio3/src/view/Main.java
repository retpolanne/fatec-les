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
        System.out.println("Escreva sair para sair");
        try {
            while (true) {
                System.out.println("Digite um nome: ");
                userIn = userReader.readLine();
                if (userIn.equals("sair"))
                    break;
                userIn = userIn.replaceAll("[aA]", "1");
                userIn = userIn.replaceAll("[bB]", "2");
                userIn = userIn.replaceAll("[cC]", "3");
                ioController.writeFile(userIn);
            }
        } catch (IOException e) {
            System.out.println("Error getting user input");
            e.printStackTrace();
        }
    }
}