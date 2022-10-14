package src.AST;

import java.util.List;

public class ASNIfStmt extends ASNStmt{
    ASNExpr ifCondition;
    List<ASNStmt> statements;

    public ASNIfStmt(){
        super("IfStmt");
    }

    public void build(){
        for(ASN child :children){
            if(child instanceof ASNStmt){
                statements.add((ASNStmt) child);
            }else if(child instanceof ASNExpr){
                ifCondition=(ASNExpr) child;
            }
        }
    }

}
