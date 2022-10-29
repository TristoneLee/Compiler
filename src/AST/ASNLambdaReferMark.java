package src.AST;

import src.parser.ScopeBuffer;
import java.util.List;
import java.util.Stack;

public class ASNLambdaReferMark extends ASN{
    public ASNLambdaReferMark(ScopeBuffer scopeBuffer){
        super("LambdaReferMark",scopeBuffer);
    }
}
