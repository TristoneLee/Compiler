package parser;

import AST.*;
import utility.Exception.CompileException;
import utility.Exception.Redeclarification;
import utility.Parameter;
import utility.ValueType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class ScopeBuffer {
    Stack<Scope> scopeBuffer;

    public Stack<ASN> controlFlow;

    public LinkedHashMap<String, ClassEntity> classTable;
    public LinkedHashMap<String, FunctionEntity> functionTable;

    public void push(Scope scope) {
        scopeBuffer.push(scope);
    }

    public ScopeBuffer(){
        scopeBuffer=new Stack<>();
        classTable=new LinkedHashMap<>();
        functionTable=new LinkedHashMap<>();
        controlFlow=new Stack<>();
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

    public ASN searchFuncDec(){
        for(int i=controlFlow.size()-1;i>=0;--i){
            if(controlFlow.get(i) instanceof ASNFuncDec) {
                ((ASNFuncDec) controlFlow.get(i)).ifReturn=true;
                return (ASNFuncDec) controlFlow.get(i);
            }else if(controlFlow.get(i) instanceof ASNLambdaExpr){
                return (ASNLambdaExpr) controlFlow.get(i);
            }
        }
        return null;
    }

    public ASN searchLoop(){
        for(int i=controlFlow.size()-1;i>=0;--i){
            if(controlFlow.get(i) instanceof ASNWhileStmt||controlFlow.get(i) instanceof ASNForStmt) {
                return controlFlow.get(i);
            }
        }
        return null;
    }

    public ASNClassDel searchClassControl(){
        for(int i=controlFlow.size()-1;i>=0;--i){
            if(controlFlow.get(i) instanceof ASNClassDel) {
                return (ASNClassDel) controlFlow.get(i);
            }
        }
        return null;
    }
}
