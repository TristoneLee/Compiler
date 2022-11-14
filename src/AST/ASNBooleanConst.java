package AST;

import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.BooleanType;

public class ASNBooleanConst extends ASNExpr{
    Boolean value;
    public ASNBooleanConst(Boolean value_, ScopeBuffer scopeBuffer){
        super(scopeBuffer);
        value=value_;
        returnType= BooleanType;
    }
}
