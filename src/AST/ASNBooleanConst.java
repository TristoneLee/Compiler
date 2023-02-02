package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.BooleanType;

public class ASNBooleanConst extends ASNExpr {
    Boolean value;

    public ASNBooleanConst(Boolean value_, ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        value = value_;
        returnType = BooleanType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return new IRVar(value ? 1 : 0, IRType.Genre.I1);
    }
}
