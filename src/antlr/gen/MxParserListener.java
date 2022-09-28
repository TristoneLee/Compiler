package src.antlr.gen;// Generated from E:/�γ�����/�����/������/Compiler-Design-Implementation/src/antlr\MxParser.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(MxParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(MxParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MxParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MxParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(MxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(MxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(MxParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(MxParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(MxParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(MxParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MxParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MxParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(MxParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(MxParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(MxParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(MxParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(MxParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(MxParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(MxParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(MxParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(MxParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(MxParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declarationStatment}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatment(MxParser.DeclarationStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarationStatment}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatment(MxParser.DeclarationStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MxParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MxParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(MxParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(MxParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(MxParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(MxParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(MxParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(MxParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(MxParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(MxParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(MxParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(MxParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void enterArrayLength(MxParser.ArrayLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void exitArrayLength(MxParser.ArrayLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#uniTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterUniTypeSpecifier(MxParser.UniTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#uniTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitUniTypeSpecifier(MxParser.UniTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(MxParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(MxParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classContent}.
	 * @param ctx the parse tree
	 */
	void enterClassContent(MxParser.ClassContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classContent}.
	 * @param ctx the parse tree
	 */
	void exitClassContent(MxParser.ClassContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classMemberDel}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDel(MxParser.ClassMemberDelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classMemberDel}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDel(MxParser.ClassMemberDelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#memberType}.
	 * @param ctx the parse tree
	 */
	void enterMemberType(MxParser.MemberTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#memberType}.
	 * @param ctx the parse tree
	 */
	void exitMemberType(MxParser.MemberTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#memberName}.
	 * @param ctx the parse tree
	 */
	void enterMemberName(MxParser.MemberNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#memberName}.
	 * @param ctx the parse tree
	 */
	void exitMemberName(MxParser.MemberNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classConstructorDel}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructorDel(MxParser.ClassConstructorDelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classConstructorDel}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructorDel(MxParser.ClassConstructorDelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classMethodDel}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodDel(MxParser.ClassMethodDelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classMethodDel}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodDel(MxParser.ClassMethodDelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterDecList}.
	 * @param ctx the parse tree
	 */
	void enterParameterDecList(MxParser.ParameterDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterDecList}.
	 * @param ctx the parse tree
	 */
	void exitParameterDecList(MxParser.ParameterDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(MxParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(MxParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(MxParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(MxParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void enterTheOperator(MxParser.TheOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void exitTheOperator(MxParser.TheOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MxParser.LiteralContext ctx);
}