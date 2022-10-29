package src.parser;

import src.utility.Exception.CompileException;
import src.utility.Exception.Redeclarification;
import src.utility.Parameter;
import src.utility.ValueType;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ScopeBuffer {
    Stack<Scope> scopeBuffer;
    Map<String, ClassEntity> classTable;
    Map<String, FunctionEntity> functionTable;

    public void push(Scope scope) {
        scopeBuffer.push(scope);
    }

    public ScopeBuffer(){
        scopeBuffer=new Stack<>();
        classTable=new HashMap<>();
        functionTable=new HashMap<>();
    }


    public void addVariable(String name, ValueType value) throws CompileException {
        if (classTable.containsKey(name) || peek().variableTable.containsKey(name)) throw new Redeclarification(name);
        else peek().variableTable.put(name, new Parameter(name,value));
    }

    public void addClass(String name, ClassEntity value) throws CompileException {
        if (classTable.containsKey(name) || peek().variableTable.containsKey(name) || functionTable.containsKey(name))
            throw new Redeclarification(name);
        else classTable.put(name, value);
    }

    public void addFunction(String funName, FunctionEntity value) throws CompileException {
        if (classTable.containsKey(funName) || functionTable.containsKey(funName)) throw new Redeclarification(funName);
        else functionTable.put(funName, value);
    }

    public ClassEntity searchClass(String className) {
        if (classTable.containsKey(className)) return classTable.get(className);
        return null;
    }

    public FunctionEntity searchFunc(String funcName) {
        for (int i = scopeBuffer.size() - 1; i >= 1; --i) {
            Scope scope = scopeBuffer.get(i);
            if (scope.funcTable.containsKey(funcName)) return scope.funcTable.get(funcName);
        }
        if (functionTable.containsKey(funcName)) return functionTable.get(funcName);
        return null;
    }

    public ValueType searchVar(String varName) {
        for (int i = scopeBuffer.size() - 1; i >= 0; --i) {
            Scope scope = scopeBuffer.get(i);
            if (scope.variableTable.containsKey(varName)) return scope.variableTable.get(varName).valueType;
        }
        return null;
    }

    public Scope peek() {
        return scopeBuffer.peek();
    }

    public Scope pop() {
        return scopeBuffer.pop();
    }

}
