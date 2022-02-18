package com.operators;

import java.util.Stack;

public abstract class AbstractOperator implements Operator {
    protected final Double argument;
    protected String operationName;

    protected AbstractOperator(OperatorDescriptor descriptor) {
        this.argument = descriptor.argument;
        this.operationName = descriptor.name;
    }

    protected void checkStack(Stack<Double> stack) throws RuntimeException{
        if (stack.empty())
            throw new RuntimeException("Stack is empty");
    }
}
