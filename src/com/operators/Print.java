package com.operators;

import java.util.Stack;

public class Print extends AbstractOperator {
    public Print(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public String execute(Stack<Double> stack) {
        checkStack(stack);
        var arg = stack.peek();
        System.out.println(arg);
        return operationName + " " + arg + "\n";
    }
}
