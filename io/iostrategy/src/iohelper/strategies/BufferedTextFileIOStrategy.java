package iohelper.strategies;

import iohelper.interfaces.IOStrategy;

import java.io.File;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class BufferedTextFileIOStrategy implements IOStrategy<File, String> {
    private BufferedReader inputReader;
    private BufferedWriter outputWriter;

    public void createReader (File file) throws IOException {
        this.inputReader = new BufferedReader(
            new FileReader(file)
        );
    }
    public void createWriter (File file, boolean append) throws IOException {
        this.outputWriter = new BufferedWriter(
            new FileWriter(file, append)
        );
    }

    public String readLine () throws IOException {
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

    public void write (String message) throws IOException {
        this.outputWriter.append(message);
        this.outputWriter.flush();
    }

    public void writeBulk (List<String> messages) throws IOException {
        for (String message : messages) {
            this.outputWriter.append(message);
        }
        this.outputWriter.flush();
    }

    public void closeReader () throws IOException {
        this.inputReader.close();
    }

    public void closeWriter () throws IOException {
        this.outputWriter.close();
    }
}