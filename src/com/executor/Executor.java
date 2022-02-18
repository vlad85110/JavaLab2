package com.executor;

import com.factory.Factory;
import com.operators.Operator;

import java.util.Stack;

public class Executor {
    private final WorkflowDescriptor descriptor;
    private final Stack<Double> stack;

    public Executor(WorkflowDescriptor descriptor) {
        this.descriptor = descriptor;
        stack = new Stack<>();
    }

    public void execute() {
        var factory = new Factory();
        for (var i : descriptor.operations) {
            var operator = factory.createObject(i);
            operator.execute(stack);
        }
    }

}
