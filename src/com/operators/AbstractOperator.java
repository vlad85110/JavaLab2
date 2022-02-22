package com.operators;

import java.util.Stack;

public abstract class AbstractOperator implements Operator {
    protected final Double[] arguments;
    protected String operationName;

    protected AbstractOperator(OperatorDescriptor descriptor) {
        this.arguments = descriptor.arguments;
        this.operationName = descriptor.name;
    }

    protected void checkStack(Stack<Double> stack) throws RuntimeException{
        if (stack.empty())
            throw new RuntimeException("Stack is empty");
    }
}
