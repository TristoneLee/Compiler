package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

abstract public class ASN {
    ASN parent;
    public List<ASN> children = new ArrayList<>();
    public String type;
    ScopeBuffer scopeBuffer;

    ASN(String type_, ScopeBuffer scopeBuffer_) {
        type = type_;
        scopeBuffer = scopeBuffer_;
    }

    public ASN getParent() {
        return parent;
    }

    public ASN getChildren(int i) {
        if (i < children.size()) {
            return children.get(i);
        } else return null;
    }

    public int getChildCount() {
        return children.size();
    }

    public void setParent(ASN parent_) {
        this.parent = parent_;
    }

    public void attachChild(ASN child_) {
        this.children.add(child_);
    }

    public void build() throws CompileException {
    }

    public void check() throws CompileException {
    }
}
