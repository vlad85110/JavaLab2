package com.parser;

import com.operators.OperatorDescriptor;
import com.executor.WorkflowDescriptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Properties;

public class Parser {
    private final WorkflowDescriptor descriptor;
    private final HashMap<String, Integer> argumentsCount;
    private static int lineCnt = 0;

    public Parser(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        descriptor = new WorkflowDescriptor();
        argumentsCount = new HashMap<>();
        var definitions = new HashMap<String, Double>();

        line = reader.readLine();
        try {
            while (line != null) {
                parseStr(line, definitions);
                line = reader.readLine();
            }
        } finally {
            fr.close();
            reader.close();
        }
    }

    public WorkflowDescriptor getDescriptor() {
        return descriptor;
    }

    private void parseStr(String line, HashMap<String, Double> definitions) {
        lineCnt++;

        if (line.startsWith("#") || line.isBlank()) return;

        var strArray = line.split(" ");
        if (strArray[0].equals("INCLUDE")) {
            try {
                readProperties(strArray[1]);
            } catch (IOException e) {
                throw new InputMismatchException("Wrong input in line " + lineCnt +
                     " none arguments for INCLUDE" + "\n" + line + "\n");
            }
            return;
        }

        if (strArray[0].equals("DEFINE")) {
            definitions.put(strArray[1], Double.parseDouble(strArray[2]));
            return;
        }

        if (descriptor.operators.containsKey(strArray[0])) {
            if (strArray.length - 1 < argumentsCount.get(strArray[0])){
                throw new InputMismatchException("Wrong input in line " + lineCnt +
                        " argument is skipped" + "\n" + line + "\n");
            }

            if (strArray.length - 1 > argumentsCount.get(strArray[0])){
                throw new InputMismatchException("Wrong input in line " + lineCnt +
                        " too much arguments" + "\n" + line + "\n");
            }

            var desc = new OperatorDescriptor(strArray[0], null);
            for (int i = 1; i <= argumentsCount.get(strArray[0]); i++) {
                desc.argument = definitions.get(strArray[i]);
                if (desc.argument == null) {
                    throw new InputMismatchException("Wrong input in line " + lineCnt +
                            " undefined symbol '" + strArray[i] + "'\n" + line + "\n");
                }
            }
            descriptor.operations.add(desc);
            return;
        }

        throw new InputMismatchException("Wrong input in line " + lineCnt + " \n" + line + "\n");
    }

    private void readProperties(String fileName) throws IOException {
        if (fileName.isEmpty()) {
            throw new IOException("");
        }
        Properties properties = new Properties();

        var reader = new FileReader(fileName);
        properties.load(reader);
        for (var i : properties.stringPropertyNames()) {
            var strArray = properties.getProperty(i).split(" ");
            descriptor.operators.put(i, strArray[0]);
            if (strArray.length == 2)
                argumentsCount.put(i, Integer.parseInt(strArray[1]));
            else
                argumentsCount.put(i, 0);
        }
    }
}
