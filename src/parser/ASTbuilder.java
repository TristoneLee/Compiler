package src.parser;

import src.AST.*;
import src.antlr.MxParser;
import src.antlr.MxParserBaseVisitor;

import java.util.Objects;
import java.util.Stack;

public class ASTbuilder extends MxParserBaseVisitor<ASN> {
    Stack<ASN> buffer;
    ASN root;

    private void push (ASN node){
        node.setParent(buffer.peek());
        buffer.push(node);
    }

    public void enterTranslationUnit(MxParser.TranslationUnitContext ctx){
        root=new ASNTransUnit();
    }

    public void exitTranslationUnit(MxParser.TranslationUnitContext ctx) {
        root=buffer.pop();
    }

    public void enterLambdaExpression (MxParser.LambdaExpressionContext cxt) {
        push(new ASNLambdaExpr());
    }

    public void exitLambdaExpression (MxParser.LambdaExpressionContext cxt) {
        ASNLambdaExpr tmpNode = (ASNLambdaExpr) buffer.pop();
        tmpNode.SetType(cxt.lambdaHead().lambdaReferMark() != null? ASNLambdaExpr.LambdaType.vaule: ASNLambdaExpr.LambdaType.refer);
        tmpNode.build();
    }

    public void enterParameter(MxParser.ParameterContext cxt) {
        buffer.push (new ASNParameter());
    }

    public void exitParameter(MxParser.ParameterContext cxt){

    }
}
