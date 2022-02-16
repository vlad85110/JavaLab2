package com.operators;

import java.util.Stack;

public class Division implements Operator {
    private final OperatorDescriptor descriptor;

    public Division(OperatorDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void execute(Stack<Integer> stack) {

    }
}
