package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNContinueStmt extends ASNStmt {
    public ASNContinueStmt(ScopeBuffer scopeBuffer){
        super("ContinueStmt",scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        if(scopeBuffer.searchLoop()==null) throw new CompileException("ContinueOutsideLoop");
    }
}
