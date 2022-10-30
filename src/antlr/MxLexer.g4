lexer grammar MxLexer;


IntegerLiteral: (NonzeroDigit (Digit)*)|'0';

StringLiteral: '"' ( '\\n' | '\\\\' | '\\"' | .)*? '"';

BooleanLiteral: False_ | True_;

Int : 'int';
Bool : 'bool';
String : 'string';
Void : 'void';

Break : 'break';
Continue : 'continue';
Else : 'else';
For : 'for';
If : 'if';
Return : 'return';
While : 'while';
True_ : 'true';
False_ : 'false';
New : 'new';
This : 'this';
Class: 'class';
Null: 'null';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';

Equal : '==';
NotEqual : '!=';

Arrow : '->';
Dot : '.';


Identifier: IdentifierNondigit (Nondigit | Digit )*;

fragment
IdentifierNondigit : [a-zA-Z];

fragment Nondigit: [a-zA-Z_];

fragment SIGN: [+-];

fragment Digit: [0-9];

fragment NonzeroDigit: [1-9];

DigitSequence: Digit+;

Whitespace: [ \t]+ -> skip;

Newline: ('\r' '\n'? | '\n') -> skip;

LineComment: '//' ~[\r\n]* -> skip;

BlockComment:   '/*' .*? '*/' -> skip;