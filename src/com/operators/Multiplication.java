package com.operators;

import java.util.Stack;

public class Multiplication implements Operator {
    private final OperatorDescriptor descriptor;

    public Multiplication(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
