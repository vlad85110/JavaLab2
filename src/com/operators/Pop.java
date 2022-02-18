package com.operators;

import java.util.Stack;

public class Pop extends AbstractOperator {
    public Pop(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        checkStack(stack);
        stack.pop();
    }
}
