package com.operators;

import java.util.Stack;

public class Sqrt implements Operator {
    private final OperatorDescriptor descriptor;

    public Sqrt(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
