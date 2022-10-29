package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.ValueType;

import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.VoidType;

public class ASNReturnStmt extends ASNStmt {
    ValueType returnType;
    ASNExpr expr;
    public ASNReturnStmt(ScopeBuffer scopeBuffer) {
        super("RetuenStmt",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(expr!=null) {
            expr.check();
            returnType=expr.returnType;
        }else returnType=VoidType;
    }
}
