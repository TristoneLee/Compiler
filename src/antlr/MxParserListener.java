// Generated from E:/课程资料/大二上/编译器/Compiler-Design-Implementation/src/antlr\MxParser.g4 by ANTLR 4.10.1
package antlr;
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
	 * Enter a parse tree produced by the {@code primaryExpression_Iden}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression_Iden(MxParser.PrimaryExpression_IdenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpression_Iden}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression_Iden(MxParser.PrimaryExpression_IdenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpression_miss}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression_miss(MxParser.PrimaryExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpression_miss}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression_miss(MxParser.PrimaryExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterThis(MxParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitThis(MxParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNull(MxParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNull(MxParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaHead}.
	 * @param ctx the parse tree
	 */
	void enterLambdaHead(MxParser.LambdaHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaHead}.
	 * @param ctx the parse tree
	 */
	void exitLambdaHead(MxParser.LambdaHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaReferMark}.
	 * @param ctx the parse tree
	 */
	void enterLambdaReferMark(MxParser.LambdaReferMarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaReferMark}.
	 * @param ctx the parse tree
	 */
	void exitLambdaReferMark(MxParser.LambdaReferMarkContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberAccess}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(MxParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberAccess}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(MxParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_miss}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_miss(MxParser.PostfixExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_miss}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_miss(MxParser.PostfixExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MxParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MxParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_(MxParser.PostfixExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_(MxParser.PostfixExpression_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayId}.
	 * @param ctx the parse tree
	 */
	void enterArrayId(MxParser.ArrayIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayId}.
	 * @param ctx the parse tree
	 */
	void exitArrayId(MxParser.ArrayIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arguementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArguementExpressionList(MxParser.ArguementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arguementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArguementExpressionList(MxParser.ArguementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_miss}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_miss(MxParser.UnaryExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_miss}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_miss(MxParser.UnaryExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_(MxParser.UnaryExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_(MxParser.UnaryExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression_array}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression_array(MxParser.NewExpression_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression_array}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression_array(MxParser.NewExpression_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression_class}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression_class(MxParser.NewExpression_classContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression_class}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression_class(MxParser.NewExpression_classContext ctx);
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
	 * Enter a parse tree produced by the {@code multiplicativeExpression_}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_(MxParser.MultiplicativeExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_(MxParser.MultiplicativeExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_miss}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_miss(MxParser.MultiplicativeExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_miss}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_miss(MxParser.MultiplicativeExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#multiplicativeOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOp(MxParser.MultiplicativeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#multiplicativeOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOp(MxParser.MultiplicativeOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_(MxParser.AdditiveExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_(MxParser.AdditiveExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_miss}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_miss(MxParser.AdditiveExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_miss}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_miss(MxParser.AdditiveExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#additiveOp}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOp(MxParser.AdditiveOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#additiveOp}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOp(MxParser.AdditiveOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_(MxParser.ShiftExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_(MxParser.ShiftExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_miss}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_miss(MxParser.ShiftExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_miss}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_miss(MxParser.ShiftExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shiftOp}.
	 * @param ctx the parse tree
	 */
	void enterShiftOp(MxParser.ShiftOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shiftOp}.
	 * @param ctx the parse tree
	 */
	void exitShiftOp(MxParser.ShiftOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_(MxParser.RelationalExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_(MxParser.RelationalExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_miss}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_miss(MxParser.RelationalExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_miss}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_miss(MxParser.RelationalExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#relationOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationOp(MxParser.RelationOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#relationOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationOp(MxParser.RelationOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_miss}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_miss(MxParser.EqualityExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_miss}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_miss(MxParser.EqualityExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_(MxParser.EqualityExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_(MxParser.EqualityExpression_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOp(MxParser.EqualityOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equalityOp}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOp(MxParser.EqualityOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_miss}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_miss(MxParser.AndExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_miss}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_miss(MxParser.AndExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_(MxParser.AndExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_(MxParser.AndExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_miss(MxParser.ExclusiveOrExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_miss(MxParser.ExclusiveOrExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_(MxParser.ExclusiveOrExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_(MxParser.ExclusiveOrExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_miss(MxParser.InclusiveOrExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_miss(MxParser.InclusiveOrExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_(MxParser.InclusiveOrExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_(MxParser.InclusiveOrExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression_}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression_(MxParser.LogicalAndExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression_}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression_(MxParser.LogicalAndExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression_miss}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression_miss(MxParser.LogicalAndExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression_miss}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression_miss(MxParser.LogicalAndExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression_miss}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression_miss(MxParser.LogicalOrExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression_miss}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression_miss(MxParser.LogicalOrExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression_}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression_(MxParser.LogicalOrExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression_}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression_(MxParser.LogicalOrExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression_miss}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_miss(MxParser.ConditionalExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression_miss}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_miss(MxParser.ConditionalExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression_}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_(MxParser.ConditionalExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression_}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_(MxParser.ConditionalExpression_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression_miss}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression_miss(MxParser.AssignmentExpression_missContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression_miss}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression_miss(MxParser.AssignmentExpression_missContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression_}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression_(MxParser.AssignmentExpression_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression_}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression_(MxParser.AssignmentExpression_Context ctx);
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
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#trueStatement}.
	 * @param ctx the parse tree
	 */
	void enterTrueStatement(MxParser.TrueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#trueStatement}.
	 * @param ctx the parse tree
	 */
	void exitTrueStatement(MxParser.TrueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#falseStatement}.
	 * @param ctx the parse tree
	 */
	void enterFalseStatement(MxParser.FalseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#falseStatement}.
	 * @param ctx the parse tree
	 */
	void exitFalseStatement(MxParser.FalseStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhileCondition(MxParser.WhileConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhileCondition(MxParser.WhileConditionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#forExpr1}.
	 * @param ctx the parse tree
	 */
	void enterForExpr1(MxParser.ForExpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExpr1}.
	 * @param ctx the parse tree
	 */
	void exitForExpr1(MxParser.ForExpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forExpr2}.
	 * @param ctx the parse tree
	 */
	void enterForExpr2(MxParser.ForExpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExpr2}.
	 * @param ctx the parse tree
	 */
	void exitForExpr2(MxParser.ForExpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forExpr3}.
	 * @param ctx the parse tree
	 */
	void enterForExpr3(MxParser.ForExpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExpr3}.
	 * @param ctx the parse tree
	 */
	void exitForExpr3(MxParser.ForExpr3Context ctx);
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
	 * Enter a parse tree produced by {@link MxParser#arrayUni}.
	 * @param ctx the parse tree
	 */
	void enterArrayUni(MxParser.ArrayUniContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayUni}.
	 * @param ctx the parse tree
	 */
	void exitArrayUni(MxParser.ArrayUniContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#newTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterNewTypeSpecifier(MxParser.NewTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitNewTypeSpecifier(MxParser.NewTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayUni}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayUni(MxParser.NewArrayUniContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayUni}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayUni(MxParser.NewArrayUniContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxParser.ParameterContext ctx);
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