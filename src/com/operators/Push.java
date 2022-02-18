package com.operators;

import java.util.Stack;

public class Push extends AbstractOperator {
    public Push(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public String execute(Stack<Double> stack) {
        return operationName + " " + stack.push(argument).toString() + "\n";
    }
}
