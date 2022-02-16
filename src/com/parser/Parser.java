package com.parser;

import com.operators.OperatorDescriptor;
import com.executor.WorkflowDescriptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Parser {
    private static int lineCnt = 0;
    public static WorkflowDescriptor parse(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        var descriptor = new WorkflowDescriptor();
        var definitions = new HashMap<String, Double>();
        line = reader.readLine();
        try {
            while (line != null) {
                parseStr(line, descriptor, definitions);
                line = reader.readLine();
            }
        }
        finally {
            fr.close();
            reader.close();
        }
        return descriptor;
    }

    private static void parseStr(String line, WorkflowDescriptor descriptor, HashMap<String, Double> definitions) {
        lineCnt++;

        if (line.startsWith("#") || line.isBlank()) return;

        var strArray = line.split(" ");

        if (strArray[0].equals("DEFINE")) {
            definitions.put(strArray[1], Double.parseDouble(strArray[2]));
            return;
        }

        if (strArray[0].equals("PUSH")) {
            if (strArray.length == 1) {
                throw new InputMismatchException("Wrong input in line " + lineCnt + " : No arguments for function" +
                        " \n" + line + "\n");
            }

            var desc = new OperatorDescriptor(strArray[0], definitions.get(strArray[1]));
            descriptor.operations.add(desc);
            return;
        }

        if (Identidier.isOperation(strArray[0])) {
            var desc = new OperatorDescriptor(strArray[0], null);
            descriptor.operations.add(desc);
            return;
        }

        throw new InputMismatchException("Wrong input in line " + lineCnt + " \n" + line + "\n");
    }
}
