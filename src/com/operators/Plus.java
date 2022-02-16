package com.operators;

import java.util.Stack;

public class Plus implements Operator {
    private final OperatorDescriptor descriptor;

    public Plus(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
