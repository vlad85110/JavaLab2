package com.factory;

import com.Main;
import com.operators.Operator;
import com.operators.OperatorDescriptor;


import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Factory {
    private HashMap<String, String> classes;

    public Factory() {
        String fileName = "src/com/Factory/Factory.properties";
        Properties prop = new Properties();

        try {
            prop.load(new FileReader(fileName));
            Map<String, String> step2 = (Map<String, String>)(Map)prop;
            classes = new HashMap<>(step2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Operator createObject(OperatorDescriptor desc) {
        Class<?> productClass;
        Operator object = null;

        try {
            productClass = Class.forName(classes.get(desc.name));
            object = (Operator) productClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("err");
        }

        return object;
    }
}
