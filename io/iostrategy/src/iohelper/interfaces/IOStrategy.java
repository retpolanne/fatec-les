package iohelper.interfaces;

import java.io.IOException;
import java.util.List;
import java.net.Socket;

public interface IOStrategy<T> {
    public void createReader (T file) throws IOException;
    public void createWriter (T file) throws IOException;
    public String readLine () throws IOException;
    public List<String> readWhole () throws IOException;
    public void write (String message, boolean append) throws IOException;
    public void closeReader () throws IOException;
    public void closeWriter () throws IOException;
}