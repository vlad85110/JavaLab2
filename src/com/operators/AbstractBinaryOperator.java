package com.operators;

import java.util.Stack;

public abstract class AbstractBinaryOperator extends AbstractOperator{
    protected AbstractBinaryOperator(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        checkStack(stack);
        var arg2 = stack.pop();
        checkStack(stack);
        var arg1 = stack.pop();

        var res = operation(arg1, arg2);
        stack.push(res);
    }

    abstract protected double operation (double arg1, double arg2);
}
