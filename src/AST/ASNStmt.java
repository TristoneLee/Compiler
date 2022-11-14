package AST;

import IR.IRBlock;
import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

abstract public class ASNStmt extends ASN {
    public ASNStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

}
