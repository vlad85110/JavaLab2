package com.executor;


import com.operators.OperatorDescriptor;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkflowDescriptor {
    public ArrayList<OperatorDescriptor> operations;
    public HashMap<String, Integer> definitions;

    public WorkflowDescriptor() {
        operations = new ArrayList<>();
        definitions = new HashMap<>();
    }
}
