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
import java.lang.ClassNotFoundException;


public class ObjectFileIOStrategy implements IOStrategy<File, Object> {
    private ObjectInputStream inputReader;
    private ObjectOutputStream outputWriter;

    @Override
    public void createReader (File file) throws IOException {
        this.inputReader = new ObjectInputStream(
            new FileInputStream(file)
        );
    }

    @Override
    public void createWriter (File file, boolean append) throws IOException {
        this.outputWriter = new ObjectOutputStream(
            new FileOutputStream(file)
        );
    }

    @Override
    public Object readLine () throws IOException {
        try {
            return this.inputReader.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> readWhole () throws IOException {
        Object line;
        List<Object> lines = new ArrayList<Object>();
        while (true) {
            try {
                line = this.inputReader.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                line = null;
            }
            if (line == null)
                break;
            lines.add(line);
        }
        return lines;
    }

    @Override
    public void write (Object message) throws IOException {
        this.outputWriter.writeObject(message);
    }

    @Override
    public void writeBulk (List<Object> messages) throws IOException {
        for (Object message : messages) {
            this.outputWriter.writeObject(message);
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