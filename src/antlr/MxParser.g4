parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

translationUnit: statement+ EOF;

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
    :   literal | arrayInitializer
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
	uniTypeSpecifier ('[' arrayLength? ']')?;

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