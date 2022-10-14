package src.parser;

import src.utility.Exception.CompileException;
import src.utility.Exception.Redeclarification;
import src.utility.Parameter;
import src.utility.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Scope {
    public enum symbolType {Class, Variable, Function}

    Set<String> classTable;
    Set<String> variableTable;
    Set<String> functionTable;
    Scope parent;
    List<Scope> children;

    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent_) {
        parent = parent_;
    }

    public void addChild(Scope child_) {
        children.add(child_);
    }


    public void add(symbolType type, String name) throws CompileException {
        switch (type) {
            case Class -> {
                if (classTable.contains(name) || variableTable.contains(name) || functionTable.contains(name))
                    throw new Redeclarification(name);
                else classTable.add(name);
            }
            case Function -> {
                if (classTable.contains(name) || functionTable.contains(name)) throw new Redeclarification(name);
                else functionTable.add(name);
            }
            case Variable -> {
                if (classTable.contains(name) || variableTable.contains(name)) throw new Redeclarification(name);
                else variableTable.add(name);
            }
        }
    }
}
