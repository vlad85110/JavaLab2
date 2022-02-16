package com.operators;

import java.util.Stack;

public interface Operator {

    public void execute(Stack<Double> stack);

    public static Operator of(OperatorDescriptor descriptor) {
        if (descriptor.name.equals("POP"))
            return new Pop(descriptor);

        if (descriptor.name.equals("PUSH"))
            return new Push(descriptor);

        if (descriptor.name.equals("+"))
            return new Plus(descriptor);

        if (descriptor.name.equals("-"))
            return new Minus(descriptor);

        if (descriptor.name.equals("*"))
            return new Multiplication(descriptor);

        if (descriptor.name.equals("/"))
            return new Division(descriptor);

        if (descriptor.name.equals("SQRT"))
            return new Sqrt(descriptor);

        if (descriptor.name.equals("PRINT"))
            return new Print(descriptor);

        throw new RuntimeException("Wrong operation name");
    }
}
