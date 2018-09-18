package iohelper.contexts;

import java.io.IOException;
import java.util.List;

import iohelper.interfaces.IOStrategy;

public class IOContext {
    private IOStrategy ioStrategy;
    private Object file;

    public IOContext (Object file) {
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

    public String readLine () {
        try {
            return this.ioStrategy.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> readWhole () {
        try {
            return this.ioStrategy.readWhole();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void write (String message, boolean append) {
        try {
            this.ioStrategy.write(message, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}