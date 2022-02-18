package com.operators;


public class Plus extends AbstractBinaryOperator {
    public Plus(OperatorDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    protected double operation (double arg1, double arg2) {
        return arg1 + arg2;
    }
}
