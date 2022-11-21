package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import java.util.List;

import static utility.ValueType.BooleanType;

public class ASNForStmt extends ASNStmt {
    ASNForExpr1 forExpr1;
    ASNExpr forExpr2;
    ASNExpr forExpr3;
    ASNStmt forStmt;

    public ASNForStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStmt) forStmt = (ASNStmt) child;
            else if (child instanceof ASNForExpr2) forExpr2 = ((ASNForExpr2) child).expr;
            else if (child instanceof ASNForExpr3) forExpr3 = ((ASNForExpr3) child).expr;
            else if (child instanceof ASNForExpr1) forExpr1 = (ASNForExpr1) child;
            else throw new InvalidExpression();
        }
    }

    public void check() throws CompileException {
        scopeBuffer.push(new Scope());
        scopeBuffer.controlFlow.push(this);
        if (forExpr1 != null) forExpr1.check();
        if (forExpr2 != null) forExpr2.check();
        if (forExpr3 != null) forExpr3.check();
        if (forExpr2 != null && !forExpr2.returnType.equals(BooleanType)) throw new InvalidExpression();
        forStmt.check();
        scopeBuffer.controlFlow.pop();
        scopeBuffer.pop();
    }

    int formerIndex;
    int expr2Index;
    int expr3Index;
    int bodyIndex;
    int forwardIndex;

    @Override
    public void controlFlowAnalysis(List<IRBlock> blocks) {
        formerIndex = blocks.size() - 1;
        if (forExpr2 != null) {
            blocks.add(new IRBlock());
            expr2Index = blocks.size()-1;
        }
        if (forExpr3 != null) {
            blocks.add(new IRBlock());
            expr3Index=blocks.size()-1;
        }
        if (forStmt != null) {
            blocks.add(new IRBlock());
            bodyIndex= blocks.size()-1;
            forStmt.controlFlowAnalysis(blocks);
        }
        blocks.add(new IRBlock());
        forwardIndex = blocks.size() -1;
    }

    @Override
    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        if(forExpr1!=null){
            forExpr1.irGeneration(blocks,localVarIndex,formerIndex,irScopeBuffer);
        }
        if(forExpr2!=null){
            forExpr2.irGeneration(blocks,localVarIndex,expr2Index,irScopeBuffer);
        }
        if(forExpr3!=null){
            forExpr3.irGeneration(blocks,localVarIndex,expr3Index,irScopeBuffer);
        }
        if(forStmt!=null){
            forStmt.irGeneration(blocks,localVarIndex,bodyIndex,irScopeBuffer);
        }
        curBlock=forwardIndex;
        return 0;
    }
}
