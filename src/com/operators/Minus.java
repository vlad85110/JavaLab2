package com.operators;

import java.util.Stack;

public class Minus implements Operator {
    private final OperatorDescriptor descriptor;

    public Minus(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
