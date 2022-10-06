package src.parser;

import src.utility.Parameter;
import src.utility.*;

import java.util.List;
import java.util.Map;


public class Scope {
    Map<String, Symbol> symbolTable;
    Scope parent;
    List<Scope> children;

    public Scope getParent(){
        return parent;
    }

    public void setParent(Scope parent_){
        parent=parent_;
    }

    public void addChild (Scope child_){
        children.add(child_);
    }

    public void add (Parameter para){
        symbolTable.put(para.name,new Symbol(Symbol.symbolType.Variable,para.type));
    }

    public void add (String name, String type){
        symbolTable.put(name,new Symbol(Symbol.symbolType.Variable,type));
    }

    public boolean ifHave(String name){
        return symbolTable.containsKey(name);
    }
}
