package com.operators;

import java.util.Stack;

public class Pop implements Operator {
    private final OperatorDescriptor descriptor;

    public Pop(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
