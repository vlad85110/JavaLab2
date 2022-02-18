package com.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private final FileWriter fileWriter;

    public void receiveMessage(String message) throws IOException {
        fileWriter.write(message);
    }

    public Logger(String fileName) throws IOException {
        File output = new File(fileName);
        fileWriter = new FileWriter(output);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}
