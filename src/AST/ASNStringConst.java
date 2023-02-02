package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCall;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.StringType;

public class ASNStringConst extends ASNExpr {
    String value;

    public ASNStringConst(String value_, ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        value = value_;
        returnType=StringType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return irBuilder.getConstString(value);
    }
}
