package src.AST;

import src.parser.ScopeBuffer;
import src.utility.ValueType;

import java.util.Objects;
import java.util.Stack;

abstract public class ASNExpr extends ASN {
    ValueType returnType;
    ASNExpr(String type_, ScopeBuffer scopeBuffer) {
        super(type_, scopeBuffer);
    }


}
