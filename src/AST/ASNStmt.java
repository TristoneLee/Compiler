package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

abstract public class ASNStmt extends ASN {
    public ASNStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return super.irGeneration(irBuilder, irFunction);
    }
}
