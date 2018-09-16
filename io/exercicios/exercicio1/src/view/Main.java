package view;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        String name = args[1];

        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(name);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}