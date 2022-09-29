parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

translationUnit: statement+ EOF;

primaryExpression:
	Identifier
	| literal+
	| 'this'
	| '(' expression ')'
	| lambdaExpression
	;

lambdaExpression:
	lambdaHead '{' functionBody '}';

lambdaHead:
	lambdaHeadRefer | lambdaHeadValue;

lambdaHeadValue:
	'[' ']' '(' parameterDecList ')' '->';

lambdaHeadRefer:
	'[' '&' ']' '(' parameterDecList ')' '->';

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

unaryExpression:
    newExpression |
    ('++' |  '--' )*
    (postfixExpression
    |   unaryOperator castExpression
    )
    ;

newExpression:
	'new' typeSpecifier;

unaryOperator
    :   '&' | '*' | '+' | '-' | '~' | '!'
    ;

castExpression
    :   unaryExpression
    ;

multiplicativeExpression
    :   castExpression      #multiplicativeExpression_miss
    |   castExpression (('*'|'/'|'%') castExpression)*      #multiplicativeExpression_
    ;

additiveExpression
    :   multiplicativeExpression    #additiveExpression_miss
    |   multiplicativeExpression (('+'|'-') multiplicativeExpression)*      #additiveExpression_
    ;

shiftExpression
    :   additiveExpression  #shiftExpression_miss
    |   additiveExpression (('<<'|'>>') additiveExpression)*    #shiftExpression_
    ;

relationalExpression
    :   shiftExpression    #relationalExpression_miss
    |   shiftExpression (('<'|'>'|'<='|'>=') shiftExpression)*     #relationalExpression_
    ;

equalityExpression
    :   relationalExpression    #equalityExpression_miss
    |   relationalExpression (('=='| '!=') relationalExpression)*   #equalityExpression_
    ;

andExpression
    :   equalityExpression  #andExpression_miss
    |   equalityExpression ( '&' equalityExpression)*   #andExpression_
    ;

exclusiveOrExpression
    :   andExpression   #exclusiveOrExpression_miss
    |   andExpression ('^' andExpression)*    #exclusiveOrExpression_
    ;

inclusiveOrExpression
    :   exclusiveOrExpression   #inclusiveOrExpression_miss
    |   exclusiveOrExpression ('|' exclusiveOrExpression)*   #inclusiveOrExpression_
    ;

logicalAndExpression
    :   inclusiveOrExpression   #logicalAndExpression_miss
    |   inclusiveOrExpression ('&&' inclusiveOrExpression)*    #logicalAndExpression_
    ;

logicalOrExpression
    :   logicalAndExpression    #logicalOrExpression_miss
    |   logicalAndExpression ( '||' logicalAndExpression)*  #logicalOrExpression_
    ;

conditionalExpression
    :   logicalOrExpression    #conditionalExpression_miss
    |   logicalOrExpression ('?' expression ':' conditionalExpression)? #conditionalExpression_
    ;

assignmentExpression
    :   conditionalExpression   #assignmentExpression_miss
    |   unaryExpression assignmentOperator assignmentExpression #assignmentExpression_
    ;

assignmentOperator
    :   '='
    ;

expression
    :   assignmentExpression (',' assignmentExpression)*|
    newExpression
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

initDeclaratorList
	:   initDeclarator (',' initDeclarator)*
	;

initDeclarator
	:   Identifier ('=' initializer)?
	;

initializer
    :   expression
    ;

arrayInitializer:
	'new' typeSpecifier;

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
	'while' '(' whileCondition ')' statement
	| 'for' '(' forCondition ')' statement;

whileCondition:
	expression| (typeSpecifier initDeclaratorList );

forCondition:
	((typeSpecifier initDeclaratorList) | expression)? ';' expression? ';' expression?;

typeSpecifier:
	uniTypeSpecifier ('[' arrayLength? ']')*;

arrayLength:
	IntergerLiteral;

uniTypeSpecifier
	: ('void'
    | 'string'
    | 'bool'
    | 'int'
    | typedefName)
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
    memberType memberName (',' memberName)* ';';

memberType:
	typeSpecifier;

memberName:
	Identifier;

classConstructorDel:
	className '(' ')' '{'functionBody'}';

classMethodDel:
	functionDeclaration;

functionDeclaration:
	returnType? functionName  '(' parameterDecList? ')' '{'functionBody '}';

parameterDecList:
	typeSpecifier parameterName (',' typeSpecifier parameterName)*;

returnType:
	typeSpecifier;

functionName:
	Identifier;

functionBody:
	statement+;

parameterName:
	Identifier;

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