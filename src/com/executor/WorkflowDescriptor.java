package com.executor;


import com.operators.OperatorDescriptor;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkflowDescriptor {
    public ArrayList<OperatorDescriptor> operations;

    public WorkflowDescriptor() {
        operations = new ArrayList<>();
    }
}
