package com.parser;

public class Identidier {
    static boolean isOperation(String name) {
        return name.equals("+") || name.equals("-") || name.equals("*")
                || name.equals("/") || name.equals("SQRT") || name.equals("PRINT") || name.equals("POP");
    }
}
