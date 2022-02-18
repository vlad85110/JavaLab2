package com.executor;

import com.factory.Factory;
import com.operators.Operator;

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

            operator.execute(stack);
        }
    }

}
