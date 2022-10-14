package src.parser;

import src.AST.*;
import src.antlr.MxParser;
import src.antlr.MxParserBaseVisitor;
import src.utility.Exception.CompileException;

import java.util.Stack;

import static java.lang.Integer.parseInt;

public class ASTbuilder extends MxParserBaseVisitor<ASN> {
    Stack<ASN> buffer;
    ASN root;

    private void push(ASN node) {
        node.setParent(buffer.peek());
        if (!buffer.empty()) buffer.peek().attachChild(node);
        buffer.push(node);
    }

    public void enterTranslationUnit(MxParser.TranslationUnitContext ctx) {
        root = new ASNTransUnit();
    }

    public void exitTranslationUnit(MxParser.TranslationUnitContext ctx) {
        root = buffer.pop();
    }

    public void enterLambdaExpression(MxParser.LambdaExpressionContext cxt) {
        push(new ASNLambdaExpr());
    }

    public void exitLambdaExpression(MxParser.LambdaExpressionContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterLambdaReferMark(MxParser.LambdaReferMarkContext ctx) {
        buffer.push(new ASNLambdaReferMark());
    }

    public void exitLambdaReferMark(MxParser.LambdaReferMarkContext ctx) {
        buffer.pop();
    }

    public void enterParameter(MxParser.ParameterContext cxt) {
        buffer.push(new ASNParameter());
    }

    public void exitParameter(MxParser.ParameterContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterTypeSpecifier(MxParser.TypeSpecifierContext cxt) {
        buffer.push(new ASNTypeSpecifier());
    }

    public void exitTypeSpecifier(MxParser.TypeSpecifierContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterUniTypeSpecifier(MxParser.UniTypeSpecifierContext cxt) {
        push(new ASNStringConst(cxt.getText()));
    }

    public void exitUniTypeSpecifier(MxParser.UniTypeSpecifierContext cxt) {
        buffer.pop();
    }

    public void enterArrayUni(MxParser.ArrayUniContext cxt) {
        buffer.push(new ASNArrayUni());
    }

    public void exitArrayUni(MxParser.ArrayUniContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterArrayLength(MxParser.ArrayLengthContext cxt) {
        buffer.push(new ASNIntConst(parseInt(cxt.IntergerLiteral().getText())));
    }

    public void exitArrayLength(MxParser.ArrayLengthContext cxt) {
        buffer.pop();
    }

    public void enterWhileStatement(MxParser.WhileStatementContext cxt) {
        buffer.push(new ASNWhileStmt());
    }

    public void exitWhileStatement(MxParser.WhileStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterIfStatement(MxParser.IfStatementContext cxt) {
        buffer.push(new ASNWhileStmt());
    }

    public void exitIfStatement(MxParser.IfStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterForStatement(MxParser.ForStatementContext cxt) {
        buffer.push(new ASNWhileStmt());
    }

    public void exitForStatement(MxParser.ForStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterBreakStatement(MxParser.BreakStatementContext cxt) {
        buffer.push(new ASNBreakStmt());
    }

    public void exitBreakStatement(MxParser.BreakStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterContinueStatement(MxParser.ContinueStatementContext cxt) {
        buffer.push(new ASNContinueStmt());
    }

    public void exitContinueStatement(MxParser.ContinueStatementContext cxt) {
        buffer.pop();
    }

    public void enterReturnStatement(MxParser.ReturnStatementContext cxt) {
        buffer.push(new ASNReturnStmt());
    }

    public void exitReturnStatement(MxParser.ReturnStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterExpressionStatement(MxParser.ExpressionStatementContext cxt) {
        buffer.push(new ASNExprStmt());
    }

    public void exitExpressionStatement(MxParser.ExpressionStatementContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterVarDeclaration(MxParser.VarDeclarationContext cxt) {
        buffer.push(new ASNVarDec());
    }

    public void exitVarDeclaration(MxParser.VarDeclarationContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterNewExpression(MxParser.NewExpressionContext cxt) {
        buffer.push(new ASNNewExpr());
    }

    public void exitNewExpression(MxParser.NewExpressionContext cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterMultiplicativeExpression(MxParser.MultiplicativeExpression_Context cxt) {
        switch (cxt.multiplicativeOp().getStop().getTokenIndex()) {
            case MxParser.Star:
                buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.star));
            case MxParser.Div:
                buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.div));
            default:
                buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.mod));
        }
    }

    public void exitMultiplicativeExpression(MxParser.MultiplicativeExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterAddictiveExpression(MxParser.AdditiveExpression_Context cxt) {
        if (cxt.additiveOp().getStop().getTokenIndex()==MxParser.Plus)
            buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.plus));
        else buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.minus));
    }

    public void exitAddictiveExpression(MxParser.AdditiveExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterShiftExpression(MxParser.ShiftExpression_Context cxt) {
        if(cxt.shiftOp().getStop().getTokenIndex()==MxParser.LeftShift)
            buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.leftShift));
        else buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.rightShift));
    }

    public void exitShiftExpression(MxParser.ShiftExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterRelationExpression(MxParser.RelationalExpression_Context cxt) {
        switch (cxt.relationOp().getStop().getTokenIndex()){
            case MxParser.Greater -> buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.greater));
            case MxParser.GreaterEqual -> buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.greaterEqual));
            case MxParser.Less -> buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.less));
            case MxParser.LessEqual -> buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.lessEqual));
        }
    }

    public void exitRelationExpression(MxParser.RelationalExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterEqualityExpression(MxParser.EqualityExpression_Context cxt) {
        if(cxt.equalityOp().getStop().getTokenIndex()==MxParser.Equal)
            buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.equal));
        else buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.notEqual));
    }

    public void exitEqualityExpression(MxParser.EqualityExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterAndExpression(MxParser.AndExpression_Context cxt) {
        buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.and));
    }

    public void exitAndExpression(MxParser.AndExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterExclusiveOrExpression(MxParser.ExclusiveOrExpression_Context cxt) {
        buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.exclusiveOr));
    }

    public void exitExclusiveOrExpression(MxParser.ExclusiveOrExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterInclusiveOrExpression(MxParser.InclusiveOrExpression_Context cxt) {
        buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.or));
    }

    public void exitInclusiveOrExpression(MxParser.InclusiveOrExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterLogicalAndExpression(MxParser.LogicalAndExpression_Context cxt) {
        buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.logicalAnd));
    }

    public void exitLogicalAndExpression(MxParser.LogicalAndExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterLogicalOrExpression(MxParser.LogicalOrExpression_Context cxt) {
        buffer.push(new ASNBinaryExpr(ASNBinaryExpr.Operate.logicalOr));
    }

    public void exitLogicalOrExpression(MxParser.LogicalOrExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

    public void enterAssignmentExpression(MxParser.AssignmentExpression_Context cxt) {

    }

    public void exitAssignmentExpression(MxParser.AssignmentExpression_Context cxt) {

    }

    public void enterConditionalExpression(MxParser.ConditionalExpression_Context cxt) {
        buffer.push(new ASNConditionalExpr());
    }

    public void exitConditionalExpression(MxParser.ConditionalExpression_Context cxt) throws CompileException {
        buffer.pop().build();
    }

}
