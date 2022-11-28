package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.IntegerType;

public class ASNIntConst extends ASNExpr{
    Integer value;
    public ASNIntConst(Integer value_, ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        value=value_;
        returnType= IntegerType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        return new IRVar(value);
    }
}
