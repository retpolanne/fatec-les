package iohelper.strategies;

import iohelper.interfaces.IOStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ObjectFileIOStrategy implements IOStrategy<File, Object> {
    private ObjectInputStream inputReader;
    private FileInputStream outputWriter;

    public void createReader (File file) throws IOException {
        this.inputReader = new BufferedReader(
            new ObjectInputStream(
                new FileInputStream(file)
            )
        );
    }
    public void createWriter (File file, boolean append) throws IOException {
        this.outputWriter = new PrintWriter(
            new ObjectOutputStream(
                new FileOutputStream(file)
            )
        );
    }

    public Object readLine () throws IOException {
        return this.inputReader.readLine();
    }

    public List<Object> readWhole () throws IOException {
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

    public void write (Object message) throws IOException {
        this.outputWriter.println(message);
    }

    public void closeReader () throws IOException {
        this.inputReader.close();
    }

    public void closeWriter () throws IOException {
        this.outputWriter.close();
    }
}