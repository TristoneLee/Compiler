package src.AST;

import java.util.List;
import java.util.Objects;

public class ASNWhileStmt extends ASN{
    ASNExpr whileCondition;
    List<ASNStmt> statements;
    public ASNWhileStmt(){
        super("WhileStmt");
    }
    public void build(){
        for(ASN child :children){
            if(child instanceof ASNStmt){
                statements.add((ASNStmt) child);
            }else if(child instanceof ASNExpr){
                whileCondition=(ASNExpr) child;
            }
        }
    }
}
