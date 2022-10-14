package src.AST;

public class ASNNewExpr extends ASNExpr{
    ASNTypeSpecifier expr;

    public ASNNewExpr(){
        super("NewExpr");
    }

    public void build(){
        expr= (ASNTypeSpecifier) children.get(0);
    }
}
