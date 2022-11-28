package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRBr;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Stack;

public class ASNBreakStmt extends ASNStmt{
    public ASNBreakStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        if(scopeBuffer.searchLoop()==null) throw new CompileException("BreakOutsideLoop");
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        irFunction.addIns(curBlock,new IRBr(irFunction.blocks.get(curBlock).breakBlock));
        return null;
    }
}
