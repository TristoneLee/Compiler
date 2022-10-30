package parser;


import utility.*;

import java.util.HashMap;
import java.util.Map;



public class Scope {
    Map<String, Parameter> variableTable;
    Map<String, FunctionEntity> funcTable;

    public Scope(){
        variableTable=new HashMap<>();
        funcTable=new HashMap<>();
    }

    public Scope(ClassEntity entity){
        variableTable=new HashMap<>();
        funcTable=new HashMap<>();
        variableTable.putAll(entity.classMember);
        funcTable.putAll(entity.classMethod);
    }
}
