package src.AST;

import java.util.List;

public class ASNFuncBody extends ASN{
    List<ASNStmt> statements;
    public ASNFuncBody(){
        super("FuncBody");
    }

    public void build(){
        for(ASN child:children)statements.add((ASNStmt) child);
    }
}
