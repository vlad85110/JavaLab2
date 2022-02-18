package com.executor;

import com.factory.Factory;
import com.logging.Logger;
import com.operators.Operator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class Executor {
    private final WorkflowDescriptor descriptor;
    private final Stack<Double> stack;

    public Executor(WorkflowDescriptor descriptor) {
        this.descriptor = descriptor;
        stack = new Stack<>();
    }

    public void execute() {
        var factory = new Factory(descriptor.operators);
        Logger logger = null;

        try {
            logger = new Logger(descriptor.fileName);
        } catch (IOException | NullPointerException e) {
            System.out.print("");
        }

        String message;
        for (var i : descriptor.operations) {
            Operator operator;
            try {
                operator = factory.createObject(i);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException
                    | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
                System.err.println("terminate with code 1");
                return;
            }

            message = operator.execute(stack);
            if (logger != null) {
                try {
                    logger.receiveMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (logger != null) {
            try {
                logger.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
