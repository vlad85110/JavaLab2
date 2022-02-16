package com.operators;

import java.util.Stack;

public class Print implements Operator {
    private final OperatorDescriptor descriptor;

    public Print(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
