package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Stack;

public class ASNBreakStmt extends ASNStmt{
    public ASNBreakStmt(ScopeBuffer scopeBuffer) {
        super("BreakStmt",scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        if(scopeBuffer.searchLoop()==null) throw new CompileException("BreakOutsideLoop");
    }
}
