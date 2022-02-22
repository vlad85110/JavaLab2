package com.operators;


public class OperatorDescriptor {
    public String name;
    public int arguments_size;
    public Double[] arguments;


    public OperatorDescriptor(String name, int arguments_size) {
        this.name = name;
        this.arguments_size = arguments_size;
        this.arguments = new Double[arguments_size];
    }
}
