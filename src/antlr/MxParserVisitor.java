// Generated from E:/课程资料/大二上/编译器/Compiler-Design-Implementation/src/antlr\MxParser.g4 by ANTLR 4.10.1
package src.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaHead(MxParser.LambdaHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaHeadValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaHeadValue(MxParser.LambdaHeadValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaHeadRefer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaHeadRefer(MxParser.LambdaHeadReferContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList(MxParser.ArgumentExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(MxParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_miss}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_miss(MxParser.MultiplicativeExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_(MxParser.MultiplicativeExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_miss}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_miss(MxParser.AdditiveExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_(MxParser.AdditiveExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_miss}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_miss(MxParser.ShiftExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_(MxParser.ShiftExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_miss}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_miss(MxParser.RelationalExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_(MxParser.RelationalExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_miss}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_miss(MxParser.EqualityExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_(MxParser.EqualityExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_miss}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_miss(MxParser.AndExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_(MxParser.AndExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_miss(MxParser.ExclusiveOrExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_(MxParser.ExclusiveOrExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_miss}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_miss(MxParser.InclusiveOrExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_(MxParser.InclusiveOrExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression_miss}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression_miss(MxParser.LogicalAndExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression_}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression_(MxParser.LogicalAndExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression_miss}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression_miss(MxParser.LogicalOrExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression_}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression_(MxParser.LogicalOrExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_miss}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_miss(MxParser.ConditionalExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_}
	 * labeled alternative in {@link MxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_(MxParser.ConditionalExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression_miss}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression_miss(MxParser.AssignmentExpression_missContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression_}
	 * labeled alternative in {@link MxParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression_(MxParser.AssignmentExpression_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(MxParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(MxParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#declarationStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatment(MxParser.DeclarationStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MxParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(MxParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(MxParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(MxParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(MxParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(MxParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(MxParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(MxParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#uniTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniTypeSpecifier(MxParser.UniTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(MxParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassContent(MxParser.ClassContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classMemberDel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDel(MxParser.ClassMemberDelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#memberType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberType(MxParser.MemberTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#memberName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberName(MxParser.MemberNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classConstructorDel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructorDel(MxParser.ClassConstructorDelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classMethodDel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodDel(MxParser.ClassMethodDelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDecList(MxParser.ParameterDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(MxParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(MxParser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#theOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheOperator(MxParser.TheOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MxParser.LiteralContext ctx);
}