package src.AST;

import src.parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.StringType;

public class ASNStringConst extends ASNExpr {
    String value;

    public ASNStringConst(String value_, ScopeBuffer scopeBuffer) {
        super("StringConst",scopeBuffer);
        value = value_;
        returnType=StringType;
    }
}
