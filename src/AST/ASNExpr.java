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

    int returnIndex;

    ASNExpr(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        return super.irGeneration(irBuilder, irFunction, curBlock);
    }
}
