package iohelper.interfaces;

import java.io.IOException;
import java.util.List;
import java.net.Socket;

public interface IOStrategy<T1, T2> {
    public void createReader (T1 file) throws IOException;
    public void createWriter (T1 file, boolean append) throws IOException;
    public String readLine () throws IOException;
    public List<T2> readWhole () throws IOException;
    public void write (T2 message) throws IOException;
    public void closeReader () throws IOException;
    public void closeWriter () throws IOException;
}