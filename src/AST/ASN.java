package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.ArrayList;
import java.util.List;

abstract public class ASN {
    ASN parent;
    public List<ASN> children = new ArrayList<>();
    ScopeBuffer scopeBuffer;

    ASN(ScopeBuffer scopeBuffer_) {
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

    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        return 0;
    }
    

    public void controlFlowAnalysis(List<IRBlock> blocks) {
    }
}
