package com.operators;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sqrt extends AbstractOperator {
    public Sqrt(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        checkStack(stack);
        var argument = stack.pop();
        var res = Math.sqrt(argument);
        stack.push(res);
    }
}
