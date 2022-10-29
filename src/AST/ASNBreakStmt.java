package src.AST;

import src.parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

public class ASNBreakStmt extends ASNStmt{
    public ASNBreakStmt(ScopeBuffer scopeBuffer) {
        super("BreakStmt",scopeBuffer);
    }
}
