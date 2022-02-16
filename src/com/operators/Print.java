package com.operators;

import java.util.Stack;

public class Print extends AbstractOperator {
    public Print(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public void execute(Stack<Double> stack) {
        //TODO format
        checkStack(stack);
        var arg = stack.peek();
        System.out.println(arg);
    }
}
