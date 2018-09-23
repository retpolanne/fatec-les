package view;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import iohelper.contexts.IOContext;
import iohelper.strategies.BufferedTextFileIOStrategy;

public class Main {
    public static void main (String[] args) {
        String srcFilePath = args[0];
        String dstFilePath = args[1];
    
        try {
            File srcFile = new File(srcFilePath);
            File dstFile = new File(dstFilePath);

            IOContext ioContextSrc = new IOContext<String, File>(srcFile);
            IOContext ioContextDst = new IOContext<String, File>(dstFile);
    
            ioContextSrc.setIOStrategy(new BufferedTextFileIOStrategy());
            ioContextDst.setIOStrategy(new BufferedTextFileIOStrategy());

            ioContextSrc.attachIO(false);
            ioContextDst.attachIO(false);
            
            Map replaceMap = createHashMap();

            replaceStrings(ioContextSrc, ioContextDst, replaceMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replaceStrings (IOContext ioSrc, IOContext ioDst, Map map) {
        List<String> lines = ioSrc.readWhole();
        List<String> newLines = new ArrayList<String>();

        for (String line : lines) {
            newLines.add(replaceChars(line, map));
        }
        return newLines;
    }

    public static String replaceChars (String line, Map map) {
        String newLine;

        for (Map.Entry<String, int> entry : map.entrySet()) {
            newLine = newLine.replaceAll(entry.getKey(), entry.getValue());
        }
        return newLine;
    }

    public static Map createHashMap() {
        Map replaceMap = new HashMap<String, int>();
        replaceMap.put("O", 0);
        replaceMap.put("I", 1);
        replaceMap.put("Z", 2);
        replaceMap.put("E", 3);
        replaceMap.put("A", 4);
        replaceMap.put("S", 5);
        replaceMap.put("G", 6);
        replaceMap.put("T", 7);
        replaceMap.put("B", 8);
        return replaceMap;
    }
}