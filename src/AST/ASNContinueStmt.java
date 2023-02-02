package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRBr;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNContinueStmt extends ASNStmt {
    public ASNContinueStmt(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        if(scopeBuffer.searchLoop()==null) throw new CompileException("ContinueOutsideLoop");
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        irFunction.addIns(irFunction.curBlock,new IRBr(irFunction.blocks.get(irFunction.curBlock).continueBlock));
        return null;
    }
}
