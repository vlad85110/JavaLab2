package com;

import com.executor.Executor;
import com.parser.Parser;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = null;
        try {
            parser = new Parser("input.txt");
        } catch (InputMismatchException e) {
            System.out.println("Unable to parse");
            e.printStackTrace();
        }

        assert parser != null;
        var descriptor = parser.getDescriptor();
        var executor = new Executor(descriptor);
        executor.execute();
    }
}
