package com.operators;

import java.util.Stack;

public class Division extends AbstractBinaryOperator {
    public Division(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    protected double operation(double arg1, double arg2) {
        return arg1 / arg2;
    }
}
