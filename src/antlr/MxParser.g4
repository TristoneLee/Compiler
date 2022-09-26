parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

translationUnit: (declaration+)? EOF;

primaryExpression:
	Identifier
	| literal+
	| 'this'
	| '(' expression ')';

postfixExpression:
    primaryExpression
	('[' expression ']'
    | '(' argumentExpressionList? ')'
    | ('.' | '->') Identifier
    | ('++' | '--')
    )*
    ;

argumentExpressionList
    :   assignmentExpression (',' assignmentExpression)*
    ;

unaryExpression
    :
    ('++' |  '--' )*
    (postfixExpression
    |   unaryOperator castExpression
    )
    ;

unaryOperator
    :   '&' | '*' | '+' | '-' | '~' | '!'
    ;

castExpression
    :   unaryExpression
    |   DigitSequence // for
    ;

multiplicativeExpression
    :   castExpression (('*'|'/'|'%') castExpression)*
    ;

additiveExpression
    :   multiplicativeExpression (('+'|'-') multiplicativeExpression)*
    ;

shiftExpression
    :   additiveExpression (('<<'|'>>') additiveExpression)*
    ;

relationalExpression
    :   shiftExpression (('<'|'>'|'<='|'>=') shiftExpression)*
    ;

equalityExpression
    :   relationalExpression (('=='| '!=') relationalExpression)*
    ;

andExpression
    :   equalityExpression ( '&' equalityExpression)*
    ;

exclusiveOrExpression
    :   andExpression ('^' andExpression)*
    ;

inclusiveOrExpression
    :   exclusiveOrExpression ('|' exclusiveOrExpression)*
    ;

logicalAndExpression
    :   inclusiveOrExpression ('&&' inclusiveOrExpression)*
    ;

logicalOrExpression
    :   logicalAndExpression ( '||' logicalAndExpression)*
    ;

conditionalExpression
    :   logicalOrExpression ('?' expression ':' conditionalExpression)?
    ;

assignmentExpression
    :   conditionalExpression
    |   unaryExpression assignmentOperator assignmentExpression
    |   DigitSequence // for
    ;

assignmentOperator
    :   '='
    ;

expression
    :   assignmentExpression (',' assignmentExpression)*
    ;

constantExpression
    :   conditionalExpression
    ;

declarationStatment
	: varDeclaration
	| classDeclaration
	| functionDeclaration
	;

varDeclaration:
	typeSpecifier initDeclaratorList ';';

//todo why use Identifier rather than declaration
initDeclaratorList
	:   initDeclarator (',' initDeclarator)*
	;

initDeclarator
	:   Identifier ('=' initializer)?
	;

initializer
    :   assignmentExpression
    |   '{' initializerList ','? '}'
    ;

initializerList
    :   designation? initializer (',' designation? initializer)*
    ;

designation
    :   designatorList '='
    ;

designatorList
    :   designator+
    ;

designator
    :   '[' constantExpression ']'
    |   '.' Identifier
    ;

statement:
	declarationStatment
	| expressionStatement
    | compoundStatement
	| selectionStatement
	| iterationStatement
	| jumpStatement;

expressionStatement:
	expression? ';';

compoundStatement:
	'{' statement* '}';

selectionStatement:
	'if' '(' expression ')' statement ('else' statement)?;

jumpStatement:
	(
		Break
		| Continue
		| Return expression?
	) ';' ;

iterationStatement:
	'while' '(' expression ')' statement
	| 'for' '(' forCondition ')' statement;

forCondition:
	((typeSpecifier initDeclaratorList) | expression)? ';' expression? ';' expression?;

typeSpecifier
	: ('void'
    | 'string'
    | 'bool'
    | 'int')
    | typedefName
    ;

typedefName
	:   Identifier
	;

className:
	Identifier;

classDeclaration:
	'class' className '{' classContent+ '}';

classContent:
	classMemberDel
	| classConstructorDel
	| classMethodDel;

classMemberDel:
    memberType memberName (',' memberName)*;

memberType:
	typeSpecifier;

memberName:
	Identifier;

classConstructorDel:
	className '(' ')' '{'functionBody'}';

classMethodDel:
	functionDeclaration;

functionDeclaration:
	returnType functionName  '(' parameterDecList ')' '{'functionBody '}';

parameterDecList:
	typeSpecifier parameterName (',' parameterName)*





theOperator:
	New (LeftBracket RightBracket)?
	| Plus
	| Minus
	| Star
	| Div
	| Mod
	| Caret
	| And
	| Or
	| Tilde
	| Not
	| Assign
	| Greater
	| Less
	| GreaterEqual
	| Less Less
	| Greater Greater
	| Equal
	| NotEqual
	| LessEqual
	| AndAnd
	| OrOr
	| PlusPlus
	| MinusMinus
	| Comma
	| Arrow
	| LeftParen RightParen
	| LeftBracket RightBracket;


literal: IntergerLiteral | StringLiteral | BooleanLiteral;