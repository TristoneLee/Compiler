package parser;

import AST.*;
import antlr.MxParser;
import antlr.MxParserBaseListener;
import utility.Exception.CompileException;

import java.util.Objects;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class ASTbuilder extends MxParserBaseListener {
    Stack<ASN> buffer;
    ScopeBuffer scopeBuffer;
    ASN root;

    public ASTbuilder() {
        buffer = new Stack<>();
        scopeBuffer = new ScopeBuffer();
    }

    private void push(ASN node) {
        node.setParent(buffer.peek());
        if (!buffer.empty()) buffer.peek().attachChild(node);
        buffer.push(node);
    }

    public void check() throws CompileException {
        initialCheck();
        root.check();
    }

    public void initialCheck() throws CompileException {
        boolean flag = false;
        scopeBuffer.push(new Scope());
        buildInInit();
        for (ASN child : root.children) {
            if (child instanceof ASNFuncDec) {
                if (Objects.equals(((ASNFuncDec) child).entity.functionName, "main")) flag = true;
                scopeBuffer.addFunction(((ASNFuncDec) child).entity.functionName, ((ASNFuncDec) child).entity);
            } else if (child instanceof ASNClassDel) {
                scopeBuffer.addClass(((ASNClassDel) child).classEntity.className, ((ASNClassDel) child).classEntity);
            }
        }
        scopeBuffer.push(new Scope());
        if (!flag) throw new CompileException("NoMainFunction");
    }

    public void buildInInit() {
        scopeBuffer.addClass("string", ClassEntity.stringClass);
        scopeBuffer.addFunction("print", FunctionEntity.funcPrint);
        scopeBuffer.addFunction("println", FunctionEntity.funcPrintln);
        scopeBuffer.addFunction("printInt", FunctionEntity.funcPrintInt);
        scopeBuffer.addFunction("printlnInt", FunctionEntity.funcPrintlnInt);
        scopeBuffer.addFunction("getString", FunctionEntity.funcGetString);
        scopeBuffer.addFunction("getInt", FunctionEntity.funcGetInt);
        scopeBuffer.addFunction("toString", FunctionEntity.funcToString);
    }

    public void enterTranslationUnit(MxParser.TranslationUnitContext ctx) {
        root = new ASNTransUnit(scopeBuffer);
        buffer.push(root);
    }

    public void exitTranslationUnit(MxParser.TranslationUnitContext ctx) {
        buffer.pop();
    }

    public void enterLambdaExpression(MxParser.LambdaExpressionContext cxt) {
        push(new ASNLambdaExpr(scopeBuffer));
    }

    public void exitLambdaExpression(MxParser.LambdaExpressionContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterLambdaReferMark(MxParser.LambdaReferMarkContext ctx) {
        push(new ASNLambdaReferMark(scopeBuffer));
    }

    public void exitLambdaReferMark(MxParser.LambdaReferMarkContext ctx) {
        buffer.pop();
    }

    public void enterParameter(MxParser.ParameterContext cxt) {
        push(new ASNParameter(scopeBuffer));
    }

    public void exitParameter(MxParser.ParameterContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterParameterName(MxParser.ParameterNameContext cxt) {
        push(new ASNStringConst(cxt.getText(), scopeBuffer));
    }

    public void exitParameterName(MxParser.ParameterNameContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterTypeSpecifier(MxParser.TypeSpecifierContext cxt) {
        push(new ASNTypeSpecifier(scopeBuffer));
    }

    public void exitTypeSpecifier(MxParser.TypeSpecifierContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterUniTypeSpecifier(MxParser.UniTypeSpecifierContext cxt) {
        push(new ASNStringConst(cxt.getText(), scopeBuffer));
    }

    public void exitUniTypeSpecifier(MxParser.UniTypeSpecifierContext cxt) {
        buffer.pop();
    }

    public void enterArrayUni(MxParser.ArrayUniContext cxt) {
        push(new ASNArrayUni(scopeBuffer));
    }

    public void exitArrayUni(MxParser.ArrayUniContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterNewArrayUni(MxParser.NewArrayUniContext cxt) {
        push(new ASNNewArrayUni(scopeBuffer));
    }

    public void exitNewArrayUni(MxParser.NewArrayUniContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterNewTypeSpecifier(MxParser.NewTypeSpecifierContext cxt){
        push(new ASNNewTypeSpecifier(scopeBuffer));
    }

    public void exitNewTypeSpecifier(MxParser.NewTypeSpecifierContext cxt) throws CompileException{
        buffer.peek().build();
        buffer.pop();
    }


    public void enterArrayLength(MxParser.ArrayLengthContext cxt) {
        push(new ASNIntConst(parseInt(cxt.IntegerLiteral().getText()), scopeBuffer));
    }

    public void exitArrayLength(MxParser.ArrayLengthContext cxt) {
        buffer.pop();
    }

    public void enterWhileStatement(MxParser.WhileStatementContext cxt) {
        push(new ASNWhileStmt(scopeBuffer));
    }

    public void exitWhileStatement(MxParser.WhileStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterIfStatement(MxParser.IfStatementContext cxt) {
        push(new ASNIfStmt(scopeBuffer));
    }

    public void exitIfStatement(MxParser.IfStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterForStatement(MxParser.ForStatementContext cxt) {
        push(new ASNForStmt(scopeBuffer));
    }

    public void exitForStatement(MxParser.ForStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterBreakStatement(MxParser.BreakStatementContext cxt) {
        push(new ASNBreakStmt(scopeBuffer));
    }

    public void exitBreakStatement(MxParser.BreakStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterContinueStatement(MxParser.ContinueStatementContext cxt) {
        push(new ASNContinueStmt(scopeBuffer));
    }

    public void exitContinueStatement(MxParser.ContinueStatementContext cxt) {
        buffer.pop();
    }

    public void enterReturnStatement(MxParser.ReturnStatementContext cxt) {
        push(new ASNReturnStmt(scopeBuffer));
    }

    public void exitReturnStatement(MxParser.ReturnStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterExpressionStatement(MxParser.ExpressionStatementContext cxt) {
        push(new ASNExprStmt(scopeBuffer));
    }

    public void exitExpressionStatement(MxParser.ExpressionStatementContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterVarDeclaration(MxParser.VarDeclarationContext cxt) {
        push(new ASNVarDec(scopeBuffer));
    }

    public void exitVarDeclaration(MxParser.VarDeclarationContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterInitDeclarator(MxParser.InitDeclaratorContext cxt) {
        push(new ASNInitDeclarator(cxt.Identifier().getText(), scopeBuffer));
    }

    public void exitInitDeclarator(MxParser.InitDeclaratorContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterFunctionDeclaration(MxParser.FunctionDeclarationContext cxt) {
        push(new ASNFuncDec(scopeBuffer));
    }

    public void exitFunctionDeclaration(MxParser.FunctionDeclarationContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterFunctionName(MxParser.FunctionNameContext cxt) {
        push(new ASNStringConst(cxt.getText(), scopeBuffer));
    }

    public void exitFunctionName(MxParser.FunctionNameContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterFunctionBody(MxParser.FunctionBodyContext cxt) {
        push(new ASNFuncBody(scopeBuffer));
    }

    public void exitFunctionBody(MxParser.FunctionBodyContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterClassDeclaration(MxParser.ClassDeclarationContext cxt) {
        push(new ASNClassDel(scopeBuffer));
    }

    public void exitClassDeclaration(MxParser.ClassDeclarationContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterClassName(MxParser.ClassNameContext cxt) {
        push(new ASNIdentifier(cxt.getText(), scopeBuffer));
    }

    public void exitClassName(MxParser.ClassNameContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterClassMemberDel(MxParser.ClassMemberDelContext cxt) {
        push(new ASNClassMemberDec(scopeBuffer));
    }

    public void exitClassMemberDel(MxParser.ClassMemberDelContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterMemberName(MxParser.MemberNameContext cxt) {
        push(new ASNStringConst(cxt.getText(), scopeBuffer));
    }

    public void exitMemberName(MxParser.MemberNameContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterClassConstructorDel(MxParser.ClassConstructorDelContext cxt) {
        push(new ASNClassConstructorDec(scopeBuffer));
    }

    public void exitClassConstructorDel(MxParser.ClassConstructorDelContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterNewExpression_array(MxParser.NewExpression_arrayContext cxt) {
        push(new ASNNewExpr(scopeBuffer));
    }

    public void exitNewExpression_array(MxParser.NewExpression_arrayContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterNewExpression_class(MxParser.NewExpression_classContext cxt) {
        push(new ASNNewExpr(scopeBuffer));
    }

    public void exitNewExpression_class(MxParser.NewExpression_classContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterMultiplicativeExpression_(MxParser.MultiplicativeExpression_Context cxt) {
        switch (cxt.multiplicativeOp().getStop().getTokenIndex()) {
            case MxParser.Star:
                push(new ASNBinaryExpr(ASNBinaryExpr.Operate.star, scopeBuffer));
            case MxParser.Div:
                push(new ASNBinaryExpr(ASNBinaryExpr.Operate.div, scopeBuffer));
            default:
                push(new ASNBinaryExpr(ASNBinaryExpr.Operate.mod, scopeBuffer));
        }
    }

    public void exitMultiplicativeExpression_(MxParser.MultiplicativeExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterAdditiveExpression_(MxParser.AdditiveExpression_Context cxt) {
        if (cxt.additiveOp().getStop().getType() == MxParser.Plus)
            push(new ASNBinaryExpr(ASNBinaryExpr.Operate.plus, scopeBuffer));
        else push(new ASNBinaryExpr(ASNBinaryExpr.Operate.minus, scopeBuffer));
    }

    public void exitAdditiveExpression_(MxParser.AdditiveExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterShiftExpression_(MxParser.ShiftExpression_Context cxt) {
        if (cxt.shiftOp().getStop().getType() == MxParser.LeftShift)
            push(new ASNBinaryExpr(ASNBinaryExpr.Operate.leftShift, scopeBuffer));
        else push(new ASNBinaryExpr(ASNBinaryExpr.Operate.rightShift, scopeBuffer));
    }

    public void exitShiftExpression_(MxParser.ShiftExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterRelationalExpression_(MxParser.RelationalExpression_Context cxt) {
        switch (cxt.relationOp().getStop().getType()) {
            case MxParser.Greater -> push(new ASNBinaryExpr(ASNBinaryExpr.Operate.greater, scopeBuffer));
            case MxParser.GreaterEqual -> push(new ASNBinaryExpr(ASNBinaryExpr.Operate.greaterEqual, scopeBuffer));
            case MxParser.Less -> push(new ASNBinaryExpr(ASNBinaryExpr.Operate.less, scopeBuffer));
            case MxParser.LessEqual -> push(new ASNBinaryExpr(ASNBinaryExpr.Operate.lessEqual, scopeBuffer));
        }
    }

    public void exitRelationalExpression_(MxParser.RelationalExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterEqualityExpression_(MxParser.EqualityExpression_Context cxt) {
        if (cxt.equalityOp().getStop().getType() == MxParser.Equal)
            push(new ASNBinaryExpr(ASNBinaryExpr.Operate.equal, scopeBuffer));
        else push(new ASNBinaryExpr(ASNBinaryExpr.Operate.notEqual, scopeBuffer));
    }

    public void exitEqualityExpression_(MxParser.EqualityExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterAndExpression_(MxParser.AndExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.and, scopeBuffer));
    }

    public void exitAndExpression_(MxParser.AndExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterExclusiveOrExpression_(MxParser.ExclusiveOrExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.exclusiveOr, scopeBuffer));
    }

    public void exitExclusiveOrExpression_(MxParser.ExclusiveOrExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterInclusiveOrExpression_(MxParser.InclusiveOrExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.or, scopeBuffer));
    }

    public void exitInclusiveOrExpression_(MxParser.InclusiveOrExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterLogicalAndExpression_(MxParser.LogicalAndExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.logicalAnd, scopeBuffer));
    }

    public void exitLogicalAndExpression_(MxParser.LogicalAndExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterLogicalOrExpression_(MxParser.LogicalOrExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.logicalOr, scopeBuffer));
    }

    public void exitLogicalOrExpression_(MxParser.LogicalOrExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterAssignmentExpression_(MxParser.AssignmentExpression_Context cxt) {
        push(new ASNBinaryExpr(ASNBinaryExpr.Operate.assign, scopeBuffer));
    }

    public void exitAssignmentExpression_(MxParser.AssignmentExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterConditionalExpression_(MxParser.ConditionalExpression_Context cxt) {
        push(new ASNConditionalExpr(scopeBuffer));
    }

    public void exitConditionalExpression_(MxParser.ConditionalExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterFunctionCall(MxParser.FunctionCallContext cxt) {
        push(new ASNFuncCall(scopeBuffer));
    }

    public void exitFunctionCall(MxParser.FunctionCallContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterArrayAccess(MxParser.ArrayAccessContext cxt) {
        push(new ASNArrayAccess(scopeBuffer));
    }

    public void exitArrayAccess(MxParser.ArrayAccessContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterMemberAccess(MxParser.MemberAccessContext cxt) {
        push(new ASNMemberAccess(scopeBuffer));
    }

    public void exitMemberAccess(MxParser.MemberAccessContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterPostfixExpression_(MxParser.PostfixExpression_Context cxt) {
        if (cxt.stop.getType() == MxParser.PlusPlus)
            push(new ASNPostfixExpr(scopeBuffer, ASNPostfixExpr.PostfixType.plusplus));
        else push(new ASNPostfixExpr(scopeBuffer, ASNPostfixExpr.PostfixType.minusminus));
    }

    public void exitPostfixExpression_(MxParser.PostfixExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterUnaryExpression_(MxParser.UnaryExpression_Context cxt) {
        switch (cxt.start.getType()) {
            case MxParser.PlusPlus -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.plusplus));
            case MxParser.Plus -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.plus));
            case MxParser.MinusMinus -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.minusminus));
            case MxParser.Minus -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.minus));
            case MxParser.Star -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.star));
            case MxParser.And -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.and));
            case MxParser.Tilde -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.tilde));
            case MxParser.Not -> push(new ASNUnaryExpr(scopeBuffer, ASNUnaryExpr.UnaryOp.not));
        }
    }

    public void exitUnaryExpression_(MxParser.UnaryExpression_Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterLiteral(MxParser.LiteralContext cxt) {
        switch (cxt.getStart().getType()) {
            case MxParser.StringLiteral -> push(new ASNStringConst(cxt.getText(), scopeBuffer));
            case MxParser.IntegerLiteral -> push(new ASNIntConst(Integer.parseInt(cxt.getText()), scopeBuffer));
            case MxParser.BooleanLiteral -> push(new ASNBooleanConst(Boolean.parseBoolean(cxt.getText()), scopeBuffer));
        }
    }

    public void exitLiteral(MxParser.LiteralContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterForExpr1(MxParser.ForExpr1Context cxt) {
        push(new ASNForExpr1(scopeBuffer));
    }

    public void exitForExpr1(MxParser.ForExpr1Context cxt) {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterForExpr2(MxParser.ForExpr2Context cxt) {
        push(new ASNForExpr2(scopeBuffer));
    }

    public void exitForExpr2(MxParser.ForExpr2Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterForExpr3(MxParser.ForExpr3Context cxt) {
        push(new ASNForExpr3(scopeBuffer));
    }

    public void exitForExpr3(MxParser.ForExpr3Context cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterNull(MxParser.NullContext cxt) {
        push(new ASNNull(scopeBuffer));
    }

    public void exitNull(MxParser.NullContext cxt) throws CompileException {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterPrimaryExpression_Iden(MxParser.PrimaryExpression_IdenContext cxt) {
        push(new ASNIdentifier(cxt.getText(), scopeBuffer));
    }

    public void exitPrimaryExpression_Iden(MxParser.PrimaryExpression_IdenContext cxt) {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterArrayId(MxParser.ArrayIdContext cxt) {
        push(new ASNArrayId(scopeBuffer));
    }

    public void exitArrayId(MxParser.ArrayIdContext cxt) {
        buffer.peek().build();
        buffer.pop();
    }

    public void enterCompoundStatement(MxParser.CompoundStatementContext cxt) {
        push(new ASNCompoundStmt(scopeBuffer));
    }

    public void exitCompoundStatement(MxParser.CompoundStatementContext cxt) {
        buffer.peek().build();
        ;
        buffer.pop();
    }

    public void enterThis(MxParser.ThisContext cxt) {
        push(new ASNThis(scopeBuffer));
    }

    public void exitThis(MxParser.ThisContext cxt) {
        buffer.peek().build();
        ;
        buffer.pop();
    }

    public void enterTrueStatement(MxParser.TrueStatementContext cxt) {
        ASNIfBranch branch = new ASNIfBranch(scopeBuffer);
        branch.dir = true;
        push(branch);
    }

    public void exitTrueStatement(MxParser.TrueStatementContext cxt) {
        buffer.peek().build();
        ;
        buffer.pop();
    }

    public void enterFalseStatement(MxParser.FalseStatementContext cxt) {
        ASNIfBranch branch = new ASNIfBranch(scopeBuffer);
        branch.dir = false;
        push(branch);
    }

    public void exitFalseStatement(MxParser.FalseStatementContext cxt) {
        buffer.peek().build();
        ;
        buffer.pop();
    }
}
