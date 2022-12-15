package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRBr;
import IR.IRIns.IRCondBr;
import IR.IRUtility.IRVar;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

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
    public void controlFlowAnalysis(IRFunction irFunction) {
        var blocks = irFunction.blocks;
        formerIndex = irFunction.blocks.size() - 1;
        if (forExpr2 != null) {
            blocks.add(new IRBlock());
            expr2Index = blocks.size() - 1;
        }
        if (forExpr3 != null) {
            blocks.add(new IRBlock());
            expr3Index = blocks.size() - 1;
        }
        if (forStmt != null) {
            var bodyBlock = new IRBlock();
            blocks.add(bodyBlock);
            bodyIndex = blocks.size() - 1;
            forStmt.controlFlowAnalysis(irFunction);
        }
        blocks.add(new IRBlock());
        forwardIndex = blocks.size() - 1;
        irFunction.setBreakBlock(bodyIndex,forwardIndex);
        if (forExpr3 != null) irFunction.setContinueBlock(bodyIndex,expr3Index);
        else irFunction.setContinueBlock(bodyIndex,bodyIndex);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        if (forExpr1 != null) {
            forExpr1.irGeneration(irBuilder, irFunction, formerIndex);
            if(forExpr2!=null)irFunction.addIns(formerIndex, new IRBr(expr2Index));
            else irFunction.addIns(formerIndex,new IRBr(bodyIndex));
        }
        if (forExpr2 != null) {
            var condVar = forExpr2.irGeneration(irBuilder, irFunction, expr2Index);
            irFunction.addIns(expr2Index, new IRCondBr(condVar, bodyIndex, forwardIndex));
        }
        if (forExpr3 != null) {
            forExpr3.irGeneration(irBuilder, irFunction, expr3Index);
            if(forExpr2!=null)irFunction.addIns(expr3Index, new IRBr(expr2Index));
            else irFunction.addIns(expr3Index,new IRBr(bodyIndex));
        }
        if (forStmt != null) {
            forStmt.irGeneration(irBuilder, irFunction, bodyIndex);
            if(forExpr2!=null)irFunction.addIns(bodyIndex, new IRBr(expr2Index));
            else irFunction.addIns(bodyIndex,new IRBr(bodyIndex));
        }
        curBlock = forwardIndex;
        return null;
    }
}
