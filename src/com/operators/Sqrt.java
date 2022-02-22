package com.operators;

import java.util.Stack;

public class Sqrt extends AbstractOperator {
    public Sqrt(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public String execute(Stack<Double> stack) {
        checkStack(stack);
        var argument = stack.pop();
        var res = Math.sqrt(argument);
        stack.push(res);
        return operationName + " " + argument + "\n";
    }
}
