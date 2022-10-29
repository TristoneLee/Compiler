package AST;

import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

public class ASNContinueStmt extends ASNStmt {
    public ASNContinueStmt(ScopeBuffer scopeBuffer){
        super("ContinueStmt",scopeBuffer);
    }
}
