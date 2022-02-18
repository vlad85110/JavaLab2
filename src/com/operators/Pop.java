package com.operators;

import java.util.Stack;

public class Pop extends AbstractOperator {
    public Pop(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public String execute(Stack<Double> stack) {
        checkStack(stack);
        return operationName + " " + stack.pop().toString() + "\n";
    }
}
