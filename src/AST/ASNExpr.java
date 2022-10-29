package AST;

import parser.ScopeBuffer;
import utility.ValueType;

import java.util.Objects;
import java.util.Stack;

abstract public class ASNExpr extends ASN {
    ValueType returnType;
    boolean ifLeftValue=false;
    ASNExpr(String type_, ScopeBuffer scopeBuffer) {
        super(type_, scopeBuffer);
    }


}
