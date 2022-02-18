package com.executor;

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
        for (var i : descriptor.operations) {
            var operator = Operator.of(i);
            operator.execute(stack);
        }
    }

}
