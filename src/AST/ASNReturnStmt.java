package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRRet;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.VoidType;

public class ASNReturnStmt extends ASNStmt {
    ValueType returnType;
    ASNExpr expr;

    public ASNReturnStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if (!children.isEmpty()) expr = (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if (expr != null) {
            expr.check();
            returnType = expr.returnType;
        } else returnType = VoidType;
        if ((scopeBuffer.searchFuncDec() instanceof ASNFuncDec upperFuncDecNode)) {
            if (!upperFuncDecNode.entity.returnType.equals(returnType) && !((upperFuncDecNode.entity.returnType.dimension != 0 || !upperFuncDecNode.entity.returnType.isBasicType()) && returnType.equals(ValueType.NullType)))
                throw new CompileException("UnmatchedReturnType");
        } else if (scopeBuffer.searchFuncDec() instanceof ASNLambdaExpr) {
            ((ASNLambdaExpr) scopeBuffer.searchFuncDec()).returnType = returnType;
        } else throw new CompileException("ReturnOutsideOfFunc");
    }

    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        if (expr != null) {
            var returnVar = expr.irGeneration(irBuilder, irFunction);
            irFunction.addIns(irFunction.curBlock, new IRRet(returnVar));
        }
        else{
            irFunction.addIns(irFunction.curBlock,new IRRet());
        }
        return null;
    }
}
