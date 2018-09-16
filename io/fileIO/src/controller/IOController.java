package controller;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IOController {
    private File file;
    private BufferedReader fileReader;
    private BufferedWriter fileWriter;
    private boolean writerClosed = true;

    public IOController (String filePath) {
        this.file = new File(filePath);
    }

    private void createFileReader () {
        try {
            this.fileReader = new BufferedReader(new FileReader(this.file));
        } catch (IOException e) {
            System.out.println("Could not create file reader");
            e.printStackTrace();
        }
    }

    private void createFileWriter () {
        try {
            this.fileWriter = new BufferedWriter(
                new FileWriter(this.file, true)
            );
        } catch (IOException e) {
            System.out.println("Could not create file writer");
            e.printStackTrace();
        }
    }

    public void readFile () {
        String fileLine;
        try {
            this.fileWriter.close();
            this.writerClosed = true;
        } catch (IOException e) {
            System.out.println("Cant close file reader");
            e.printStackTrace();
        }
        this.createFileReader();
        try {
            while ((fileLine = this.fileReader.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        } finally {
            try {
                this.fileReader.close();
            } catch (IOException e) {
                System.out.println("Cant close file reader");
                e.printStackTrace();
            }
        }
    }

    public void writeFile (String message) {
        if (this.writerClosed) {
            this.createFileWriter();
            this.writerClosed = false;
        }
        try {
            this.fileWriter.append(message + "\r\n");
        } catch (IOException e) {
            System.out.println("Error writing file");
            e.printStackTrace();
        }
    }

    public void closeResources () {
        try {
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error closing resources");
            e.printStackTrace();
        }
    }

}