package src.AST;

import src.parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

abstract public  class ASNStmt extends ASN {
    public ASNStmt(String type_, ScopeBuffer scopeBuffer) {
        super(type_,scopeBuffer);
    }
}
