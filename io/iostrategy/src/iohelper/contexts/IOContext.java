package iohelper.contexts;

import java.io.IOException;
import java.util.List;

import iohelper.interfaces.IOStrategy;

public class IOContext<T1, T2> {
    private IOStrategy ioStrategy;
    private T2 file;

    public IOContext (T2 file) {
        this.file = file;
    }

    public void setIOStrategy (IOStrategy ioStrategy) {
        this.ioStrategy = ioStrategy;
    }

    public void attachIO (boolean append) {
        try {
            this.ioStrategy.createReader(this.file);
            this.ioStrategy.createWriter(this.file, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeIO () {
        try {
            this.ioStrategy.closeReader();
            this.ioStrategy.closeWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T1 readLine () {
        try {
            return this.ioStrategy.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<T1> readWhole () {
        try {
            return this.ioStrategy.readWhole();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void write (T1 message) {
        try {
            this.ioStrategy.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBulk (List<T1> messages) {
        try {
            this.ioStrategy.writeBulk(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}