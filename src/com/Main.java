package com;

import com.executor.Executor;
import com.parser.Parser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    var descriptor = Parser.parse("input.txt");
        var executor = new Executor(descriptor);
        executor.execute();
    }
}
