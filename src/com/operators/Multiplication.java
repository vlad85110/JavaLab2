package com.operators;

import java.util.Stack;

public class Multiplication extends AbstractOperator {
    public Multiplication(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        checkStack(stack);
        var arg2 = stack.pop();
        checkStack(stack);
        var arg1 = stack.pop();

        var res = arg1 * arg2;
        stack.push(res);
    }
}
