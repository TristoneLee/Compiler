package AST;

import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.IntegerType;

public class ASNIntConst extends ASNExpr{
    Integer value;
    public ASNIntConst(Integer value_, ScopeBuffer scopeBuffer) {
        super("IntConst",scopeBuffer);
        value=value_;
        returnType= IntegerType;
    }
}
