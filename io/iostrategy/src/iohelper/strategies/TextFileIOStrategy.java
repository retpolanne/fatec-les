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

public class TextFileIOStrategy implements IOStrategy<File, String> {
    private BufferedReader inputReader;
    private PrintWriter outputWriter;

    @Override
    public void createReader (File file) throws IOException {
        this.inputReader = new BufferedReader(
            new FileReader(file)
        );
    }

    @Override
    public void createWriter (File file, boolean append) throws IOException {
        this.outputWriter = new PrintWriter(
            new FileWriter(file, append)
        );
    }

    @Override
    public String readLine () throws IOException {
        return this.inputReader.readLine();
    }

    @Override
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

    @Override
    public void write (String message) throws IOException {
        this.outputWriter.println(message);
    }

    @Override
    public void writeBulk (List<String> messages) throws IOException {
        for (String message : messages) {
            this.outputWriter.println(message);
        }
    }

    @Override
    public void closeReader () throws IOException {
        this.inputReader.close();
    }

    @Override
    public void closeWriter () throws IOException {
        this.outputWriter.close();
    }
}