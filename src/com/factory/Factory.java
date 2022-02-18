package com.factory;

import com.operators.Operator;
import com.operators.OperatorDescriptor;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public record Factory(HashMap<String, String> classes) {

    public Operator createObject(OperatorDescriptor desc) throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class<?> productClass;
        Operator object;

        try {
            productClass = Class.forName("com.operators." + classes.get(desc.name));
            object = (Operator) productClass.getConstructor(desc.getClass()).newInstance(desc);

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchMethodException e) {
            System.err.println("Undefined class\n");
            throw e;
        }

        return object;
    }
}
