parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

translationUnit: statement+ EOF;

primaryExpression:
	Identifier  #primaryExpression_Iden
	| literal   #primaryExpression_miss
	| 'this' #primaryExpression_this
	| '(' expression ')'  #primaryExpression_miss
	| lambdaExpression  #primaryExpression_miss
	;

lambdaExpression:
	lambdaHead '{' functionBody '}';

lambdaHead:
	'[' lambdaReferMark? ']' '(' parameterDecList? ')' '->';

lambdaReferMark: '&';

postfixExpression:
    primaryExpression   #postfixExpression_miss
    | postfixExpression  '[' expression ']' #postfixExpression_arrayAccess
                          | '.'  Identifier  #postfixExpression_member
                          | ('++' | '--')  #postfixExpression_
                          | '(' argumentExpressionList? ')'  #functionCall
    ;

argumentExpressionList
    :   assignmentExpression (',' assignmentExpression)*
    ;

unaryExpression:
     postfixExpression     #unaryExpression_miss
    |   ('++' |  '--' | unaryOperator) unaryExpression  #unaryExpression_
    |    newExpression   #unaryExpression_miss;


newExpression:
	'new' typeSpecifier;

unaryOperator
    :   '&' | '*' | '+' | '-' | '~' | '!'
    ;

multiplicativeExpression
    :   unaryExpression      #multiplicativeExpression_miss
    |   multiplicativeExpression multiplicativeOp unaryExpression     #multiplicativeExpression_
    ;

multiplicativeOp: '*'|'/'|'%';

additiveExpression
    :   additiveExpression additiveOp multiplicativeExpression      #additiveExpression_
    |   multiplicativeExpression    #additiveExpression_miss
    ;

additiveOp: '+' | '-';

shiftExpression
    :   additiveExpression  #shiftExpression_miss
    |   shiftExpression shiftOp additiveExpression    #shiftExpression_
    ;

shiftOp: '<<' | '>>';

relationalExpression
    :   shiftExpression    #relationalExpression_miss
    |   relationalExpression relationOp shiftExpression     #relationalExpression_
    ;

relationOp: '<' | '>' | '<=' | '>=';

equalityExpression
    :   relationalExpression    #equalityExpression_miss
    |   equalityExpression equalityOp relationalExpression   #equalityExpression_
    ;

equalityOp: '==' | '!=';

andExpression
    :   equalityExpression  #andExpression_miss
    |   andExpression '&' equalityExpression   #andExpression_
    ;

exclusiveOrExpression
    :   andExpression   #exclusiveOrExpression_miss
    |   exclusiveOrExpression '^' andExpression    #exclusiveOrExpression_
    ;

inclusiveOrExpression
    :   exclusiveOrExpression   #inclusiveOrExpression_miss
    |   inclusiveOrExpression '|' exclusiveOrExpression   #inclusiveOrExpression_
    ;

logicalAndExpression
    :   inclusiveOrExpression   #logicalAndExpression_miss
    |   logicalAndExpression '&&' inclusiveOrExpression    #logicalAndExpression_
    ;

logicalOrExpression
    :   logicalAndExpression    #logicalOrExpression_miss
    |   logicalOrExpression  '||' logicalAndExpression  #logicalOrExpression_
    ;

conditionalExpression
    :   logicalOrExpression    #conditionalExpression_miss
    |   logicalOrExpression ('?' expression ':' conditionalExpression)? #conditionalExpression_
    ;

assignmentExpression
    :   conditionalExpression   #assignmentExpression_miss
    |   unaryExpression '=' assignmentExpression #assignmentExpression_
    ;

expression
    :   assignmentExpression
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


statement:
	declarationStatment
	| expressionStatement
    | compoundStatement
	| ifStatement
	| iterationStatement
	| jumpStatement;

expressionStatement:
	expression? ';';

compoundStatement:
	'{' statement* '}';

ifStatement:
	'if' '(' expression ')' statement ('else' statement)?;

jumpStatement: breakStatement | continueStatement | returnStatement;

breakStatement: Break ';';

continueStatement: Continue ';';

returnStatement: Return expression? ';';

iterationStatement:
	whileStatement | forStatement;

whileStatement:
	'while' '(' whileCondition ')' statement;

forStatement:
	'for' '(' forCondition ')' statement;

whileCondition:
	expression;

forCondition:
	(typeSpecifier initDeclaratorList )? ';' expression? ';' expression?;

typeSpecifier:
	uniTypeSpecifier arrayUni*;

arrayUni:
	'[' arrayLength? ']';


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
	'class' className '{' classContent+ '}' ';';

classContent:
	classMemberDel
	| classConstructorDel
	| classMethodDel
	;

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
	returnType functionName  '(' parameterDecList? ')' '{'functionBody '}';

parameterDecList:
	parameter (',' parameter)*;

parameter:
	typeSpecifier parameterName;

returnType:
	typeSpecifier;

functionName:
	Identifier;

functionBody:
	statement*;

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