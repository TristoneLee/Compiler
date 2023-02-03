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
    ASNStmt forExpr1;
    ASNExpr forExpr2;
    ASNExpr forExpr3;
    ASNStmt forStmt;

    public ASNForStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNForExpr2) forExpr2 = ((ASNForExpr2) child).expr;
            else if (child instanceof ASNForExpr3) forExpr3 = ((ASNForExpr3) child).expr;
            else if (child instanceof ASNForExpr1) forExpr1 = (ASNStmt) child;
            else if (child instanceof ASNStmt) forStmt = (ASNStmt) child;
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

    IRBlock expr2Index = new IRBlock();
    IRBlock expr3Index = new IRBlock();
    IRBlock bodyIndex = new IRBlock();
    IRBlock forwardIndex = new IRBlock();


    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        if (forExpr1 != null) {
            forExpr1.irGeneration(irBuilder, irFunction);
        }
        if (forExpr2 != null) irFunction.addIns(new IRBr(expr2Index));
        else irFunction.addIns(new IRBr(bodyIndex));

        if (forExpr2 != null) {
            irFunction.curBlock = expr2Index;
            irFunction.blocks.add(expr2Index);
            var condVar = forExpr2.irGeneration(irBuilder, irFunction);
            irFunction.addIns(new IRCondBr(condVar, bodyIndex, forwardIndex));
        }
        if (forExpr3 != null) {
            irFunction.curBlock = expr3Index;
            irFunction.blocks.add(expr3Index);
            forExpr3.irGeneration(irBuilder, irFunction);
            if (forExpr2 != null) irFunction.addIns(new IRBr(expr2Index));
            else irFunction.addIns(new IRBr(bodyIndex));
        }
        irFunction.curBlock = bodyIndex;
        var oldBreak=irFunction.breakBlock;
        var oldContinue=irFunction.continueBlock;
        irFunction.setBreakBlock(forwardIndex);
        if(forExpr3!=null)irFunction.setContinueBlock(expr3Index);
        else if(forExpr2!=null) irFunction.setContinueBlock(expr2Index);
        else irFunction.setContinueBlock(bodyIndex);
        irFunction.blocks.add(bodyIndex);
        forStmt.irGeneration(irBuilder, irFunction);
        irFunction.setContinueBlock(oldContinue);
        irFunction.setBreakBlock(oldBreak);
        if (forExpr3 != null) irFunction.addIns(new IRBr(expr3Index));
        else if (forExpr2 != null) irFunction.addIns(new IRBr(expr2Index));
        else irFunction.addIns(new IRBr(bodyIndex));
        irFunction.curBlock = forwardIndex;
        irFunction.blocks.add(forwardIndex);
        return null;
    }
}
