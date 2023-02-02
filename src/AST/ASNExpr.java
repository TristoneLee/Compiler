package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.ValueType;

import java.util.Objects;
import java.util.Stack;

abstract public class ASNExpr extends ASN {
    ValueType returnType;
    boolean ifLeftValue = false;
    boolean ifLoad=true;

    ASNExpr(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return super.irGeneration(irBuilder, irFunction);
    }
}
