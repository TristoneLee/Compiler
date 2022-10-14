package src.AST;

import src.utility.Exception.CompileException;

public class ASNExprStmt extends ASNStmt{
    ASNExpr expr;

    public ASNExprStmt(){
        super("ExprStmt");
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }
}
