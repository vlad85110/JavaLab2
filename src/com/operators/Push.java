package com.operators;

import java.util.Stack;

public class Push implements Operator {
    private final OperatorDescriptor descriptor;

    public Push(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
