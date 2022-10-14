package src.AST;

import src.utility.Exception.CompileException;

public class ASNReturnStmt extends ASNStmt {
    ASNExpr expr;
    public ASNReturnStmt() {
        super("RetuenStmt");
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }
}
