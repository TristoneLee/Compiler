package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;

public class ASNExprStmt extends ASNStmt{
    ASNExpr expr;

    public ASNExprStmt(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(expr!=null)expr.check();
    }

    @Override
    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        expr.irGeneration(blocks,localVarIndex,curBlock,irScopeBuffer);
        return 0;
    }
}
