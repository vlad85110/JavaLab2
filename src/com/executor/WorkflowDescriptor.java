package com.executor;


import com.operators.OperatorDescriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkflowDescriptor {
    public ArrayList<OperatorDescriptor> operations;
    public HashMap<String, String> operators;
    public String fileName;

    public WorkflowDescriptor() {
        operations = new ArrayList<>();
        operators = new HashMap<>();
    }
}
