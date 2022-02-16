package com.operators;

import java.util.Stack;

public class Push extends AbstractOperator {
    public Push(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        stack.push(argument);
    }
}
