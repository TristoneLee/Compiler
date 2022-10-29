package src.AST;

import src.parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.BooleanType;

public class ASNBooleanConst extends ASNExpr{
    Boolean value;
    public ASNBooleanConst(Boolean value_, ScopeBuffer scopeBuffer){
        super("BooleanConst",scopeBuffer);
        value=value_;
        returnType= BooleanType;
    }
}
