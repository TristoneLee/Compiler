package src.parser;

import src.AST.*;
import src.antlr.MxParser;
import src.antlr.MxParserBaseListener;

import java.util.Stack;

public class ASTbuilder extends MxParserBaseListener {
    Stack<ASN> buffer;
    ASN root;

    private void push (ASN node){
        node.setParent(buffer.peek());
        buffer.push(node);
    }

    private void pop (){
        if(buffer.size()==1){
            root= buffer.peek();
            buffer.pop();
            return;
        }
        ASN tem=buffer.pop();
        buffer.peek().attachChild(tem);
    }

    public void enterTranslationUnit(MxParser.TranslationUnitContext ctx){
        root=new ASNTransUnit();
    }

    public void exitTranslationUnit(MxParser.TranslationUnitContext ctx) {
        pop();
    }
}
