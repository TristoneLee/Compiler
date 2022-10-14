package src.AST;

import src.utility.Exception.CompileException;

import java.util.List;

abstract public class ASN {
    ASN parent;
    List<ASN> children;
    String type;

    ASN(String type_){
        type =type_;
    }
    public ASN getParent() {
        return parent;
    }

    public ASN getChildren(int i) {
        if (i < children.size()) {
            return children.get(i);
        } else return null;
    }

    public int getChildCount(){
        return children.size();
    }

    public void setParent(ASN parent_){this.parent=parent_;}

    public void attachChild (ASN child_){
        this.children.add(child_);
    }

    public void build() throws CompileException {}
}
