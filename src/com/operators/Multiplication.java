package com.operators;

import java.util.Stack;

public class Multiplication extends AbstractBinaryOperator {
    public Multiplication(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    protected double operation(double arg1, double arg2) {
        return arg1 * arg2;
    }
}
