package src.AST;

public class ASNConditionalExpr extends ASNExpr{
    ASNExpr case1,case2,condition;

    public ASNConditionalExpr(){
        super("ConditionalExpr");
    }

    public void build(){
        condition= (ASNExpr) children.get(0);
        case1= (ASNExpr) children.get(1);
        case2= (ASNExpr) children.get(2);
    }
}
