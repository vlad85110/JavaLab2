package com.parser;

import com.operators.OperatorDescriptor;
import com.executor.WorkflowDescriptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class Parser {
    public static WorkflowDescriptor parse(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        var descriptor = new WorkflowDescriptor();
        line = reader.readLine();
        while (line != null) {
            parseStr(line, descriptor);
            line = reader.readLine();
        }
        fr.close();
        reader.close();
        return descriptor;
    }

    private static void parseStr(String line, WorkflowDescriptor descriptor) {
        var strArray = line.split(" ");

        if (strArray[0].equals("DEFINE")) {
            descriptor.definitions.put(strArray[1], Integer.parseInt(strArray[2]));
            return;
        }

        if (strArray[0].equals("PUSH") || strArray[0].equals("POP")) {
            var desc = new OperatorDescriptor(strArray[0], Double.parseDouble(strArray[1]));
            descriptor.operations.add(desc);
            return;
        }

        if (Identidier.isOperation(strArray[0])) {
            var desc = new OperatorDescriptor(strArray[0], null);
            descriptor.operations.add(desc);
            return;
        }

        throw new InputMismatchException("Wrong input");
    }
}
