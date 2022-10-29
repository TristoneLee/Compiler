// Generated from E:/课程资料/大二上/编译器/Compiler-Design-Implementation/src/antlr\MxLexer.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntergerLiteral=1, StringLiteral=2, BooleanLiteral=3, Int=4, Bool=5, String=6, 
		Void=7, Break=8, Continue=9, Else=10, For=11, If=12, Return=13, While=14, 
		True_=15, False_=16, New=17, This=18, Class=19, Null=20, LeftParen=21, 
		RightParen=22, LeftBracket=23, RightBracket=24, LeftBrace=25, RightBrace=26, 
		Less=27, LessEqual=28, Greater=29, GreaterEqual=30, LeftShift=31, RightShift=32, 
		Plus=33, PlusPlus=34, Minus=35, MinusMinus=36, Star=37, Div=38, Mod=39, 
		And=40, Or=41, AndAnd=42, OrOr=43, Caret=44, Not=45, Tilde=46, Question=47, 
		Colon=48, Semi=49, Comma=50, Assign=51, Equal=52, NotEqual=53, Arrow=54, 
		Dot=55, Identifier=56, DigitSequence=57, Whitespace=58, Newline=59, LineComment=60;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IntergerLiteral", "StringLiteral", "BooleanLiteral", "Int", "Bool", 
			"String", "Void", "Break", "Continue", "Else", "For", "If", "Return", 
			"While", "True_", "False_", "New", "This", "Class", "Null", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
			"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
			"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Arrow", "Dot", "Identifier", 
			"IdentifierNondigit", "Nondigit", "SIGN", "Digit", "NonzeroDigit", "DigitSequence", 
			"EscapeSequence", "Schar", "Whitespace", "Newline", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'int'", "'bool'", "'string'", "'void'", "'break'", 
			"'continue'", "'else'", "'for'", "'if'", "'return'", "'while'", "'true'", 
			"'false'", "'new'", "'this'", "'class'", "'null'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", 
			"'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", 
			"'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'=='", "'!='", 
			"'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IntergerLiteral", "StringLiteral", "BooleanLiteral", "Int", "Bool", 
			"String", "Void", "Break", "Continue", "Else", "For", "If", "Return", 
			"While", "True_", "False_", "New", "This", "Class", "Null", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
			"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
			"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Arrow", "Dot", "Identifier", 
			"DigitSequence", "Whitespace", "Newline", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000<\u0184\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u008a\b\u0000\n\u0000\f\u0000\u008d\t\u0000\u0001\u0000\u0003\u0000"+
		"\u0090\b\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u0094\b\u0001\n\u0001"+
		"\f\u0001\u0097\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u009d\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!"+
		"\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001"+
		".\u0001.\u0001/\u0001/\u00010\u00010\u00011\u00011\u00012\u00012\u0001"+
		"3\u00013\u00013\u00014\u00014\u00014\u00015\u00015\u00015\u00016\u0001"+
		"6\u00017\u00017\u00017\u00057\u014f\b7\n7\f7\u0152\t7\u00018\u00018\u0001"+
		"9\u00019\u0001:\u0001:\u0001;\u0001;\u0001<\u0001<\u0001=\u0004=\u015f"+
		"\b=\u000b=\f=\u0160\u0001>\u0001>\u0001>\u0001?\u0001?\u0003?\u0168\b"+
		"?\u0001@\u0004@\u016b\b@\u000b@\f@\u016c\u0001@\u0001@\u0001A\u0001A\u0003"+
		"A\u0173\bA\u0001A\u0003A\u0176\bA\u0001A\u0001A\u0001B\u0001B\u0001B\u0001"+
		"B\u0005B\u017e\bB\nB\fB\u0181\tB\u0001B\u0001B\u0000\u0000C\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O("+
		"Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q\u0000s\u0000u\u0000w\u0000y\u0000{9"+
		"}\u0000\u007f\u0000\u0081:\u0083;\u0085<\u0001\u0000\b\u0003\u0000AZ_"+
		"_az\u0002\u0000++--\u0001\u000009\u0001\u000019\u0003\u0000\"\"\\\\nn"+
		"\u0001\u0000 ~\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u0188\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001"+
		"\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000"+
		"\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000"+
		"Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001"+
		"\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000"+
		"\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000"+
		"_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001"+
		"\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000"+
		"\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000"+
		"m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000{\u0001"+
		"\u0000\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000\u0000\u0083\u0001"+
		"\u0000\u0000\u0000\u0000\u0085\u0001\u0000\u0000\u0000\u0001\u008f\u0001"+
		"\u0000\u0000\u0000\u0003\u0091\u0001\u0000\u0000\u0000\u0005\u009c\u0001"+
		"\u0000\u0000\u0000\u0007\u009e\u0001\u0000\u0000\u0000\t\u00a2\u0001\u0000"+
		"\u0000\u0000\u000b\u00a7\u0001\u0000\u0000\u0000\r\u00ae\u0001\u0000\u0000"+
		"\u0000\u000f\u00b3\u0001\u0000\u0000\u0000\u0011\u00b9\u0001\u0000\u0000"+
		"\u0000\u0013\u00c2\u0001\u0000\u0000\u0000\u0015\u00c7\u0001\u0000\u0000"+
		"\u0000\u0017\u00cb\u0001\u0000\u0000\u0000\u0019\u00ce\u0001\u0000\u0000"+
		"\u0000\u001b\u00d5\u0001\u0000\u0000\u0000\u001d\u00db\u0001\u0000\u0000"+
		"\u0000\u001f\u00e0\u0001\u0000\u0000\u0000!\u00e6\u0001\u0000\u0000\u0000"+
		"#\u00ea\u0001\u0000\u0000\u0000%\u00ef\u0001\u0000\u0000\u0000\'\u00f5"+
		"\u0001\u0000\u0000\u0000)\u00fa\u0001\u0000\u0000\u0000+\u00fc\u0001\u0000"+
		"\u0000\u0000-\u00fe\u0001\u0000\u0000\u0000/\u0100\u0001\u0000\u0000\u0000"+
		"1\u0102\u0001\u0000\u0000\u00003\u0104\u0001\u0000\u0000\u00005\u0106"+
		"\u0001\u0000\u0000\u00007\u0108\u0001\u0000\u0000\u00009\u010b\u0001\u0000"+
		"\u0000\u0000;\u010d\u0001\u0000\u0000\u0000=\u0110\u0001\u0000\u0000\u0000"+
		"?\u0113\u0001\u0000\u0000\u0000A\u0116\u0001\u0000\u0000\u0000C\u0118"+
		"\u0001\u0000\u0000\u0000E\u011b\u0001\u0000\u0000\u0000G\u011d\u0001\u0000"+
		"\u0000\u0000I\u0120\u0001\u0000\u0000\u0000K\u0122\u0001\u0000\u0000\u0000"+
		"M\u0124\u0001\u0000\u0000\u0000O\u0126\u0001\u0000\u0000\u0000Q\u0128"+
		"\u0001\u0000\u0000\u0000S\u012a\u0001\u0000\u0000\u0000U\u012d\u0001\u0000"+
		"\u0000\u0000W\u0130\u0001\u0000\u0000\u0000Y\u0132\u0001\u0000\u0000\u0000"+
		"[\u0134\u0001\u0000\u0000\u0000]\u0136\u0001\u0000\u0000\u0000_\u0138"+
		"\u0001\u0000\u0000\u0000a\u013a\u0001\u0000\u0000\u0000c\u013c\u0001\u0000"+
		"\u0000\u0000e\u013e\u0001\u0000\u0000\u0000g\u0140\u0001\u0000\u0000\u0000"+
		"i\u0143\u0001\u0000\u0000\u0000k\u0146\u0001\u0000\u0000\u0000m\u0149"+
		"\u0001\u0000\u0000\u0000o\u014b\u0001\u0000\u0000\u0000q\u0153\u0001\u0000"+
		"\u0000\u0000s\u0155\u0001\u0000\u0000\u0000u\u0157\u0001\u0000\u0000\u0000"+
		"w\u0159\u0001\u0000\u0000\u0000y\u015b\u0001\u0000\u0000\u0000{\u015e"+
		"\u0001\u0000\u0000\u0000}\u0162\u0001\u0000\u0000\u0000\u007f\u0167\u0001"+
		"\u0000\u0000\u0000\u0081\u016a\u0001\u0000\u0000\u0000\u0083\u0175\u0001"+
		"\u0000\u0000\u0000\u0085\u0179\u0001\u0000\u0000\u0000\u0087\u008b\u0003"+
		"y<\u0000\u0088\u008a\u0003w;\u0000\u0089\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0090\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0090\u00050\u0000\u0000\u008f"+
		"\u0087\u0001\u0000\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090"+
		"\u0002\u0001\u0000\u0000\u0000\u0091\u0095\u0005\"\u0000\u0000\u0092\u0094"+
		"\u0003\u007f?\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001"+
		"\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001"+
		"\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0005\"\u0000\u0000\u0099\u0004\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0003\u001f\u000f\u0000\u009b\u009d\u0003\u001d"+
		"\u000e\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u0006\u0001\u0000\u0000\u0000\u009e\u009f\u0005i\u0000"+
		"\u0000\u009f\u00a0\u0005n\u0000\u0000\u00a0\u00a1\u0005t\u0000\u0000\u00a1"+
		"\b\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005b\u0000\u0000\u00a3\u00a4"+
		"\u0005o\u0000\u0000\u00a4\u00a5\u0005o\u0000\u0000\u00a5\u00a6\u0005l"+
		"\u0000\u0000\u00a6\n\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005s\u0000"+
		"\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9\u00aa\u0005r\u0000\u0000\u00aa"+
		"\u00ab\u0005i\u0000\u0000\u00ab\u00ac\u0005n\u0000\u0000\u00ac\u00ad\u0005"+
		"g\u0000\u0000\u00ad\f\u0001\u0000\u0000\u0000\u00ae\u00af\u0005v\u0000"+
		"\u0000\u00af\u00b0\u0005o\u0000\u0000\u00b0\u00b1\u0005i\u0000\u0000\u00b1"+
		"\u00b2\u0005d\u0000\u0000\u00b2\u000e\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0005b\u0000\u0000\u00b4\u00b5\u0005r\u0000\u0000\u00b5\u00b6\u0005e"+
		"\u0000\u0000\u00b6\u00b7\u0005a\u0000\u0000\u00b7\u00b8\u0005k\u0000\u0000"+
		"\u00b8\u0010\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005c\u0000\u0000\u00ba"+
		"\u00bb\u0005o\u0000\u0000\u00bb\u00bc\u0005n\u0000\u0000\u00bc\u00bd\u0005"+
		"t\u0000\u0000\u00bd\u00be\u0005i\u0000\u0000\u00be\u00bf\u0005n\u0000"+
		"\u0000\u00bf\u00c0\u0005u\u0000\u0000\u00c0\u00c1\u0005e\u0000\u0000\u00c1"+
		"\u0012\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005e\u0000\u0000\u00c3\u00c4"+
		"\u0005l\u0000\u0000\u00c4\u00c5\u0005s\u0000\u0000\u00c5\u00c6\u0005e"+
		"\u0000\u0000\u00c6\u0014\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005f\u0000"+
		"\u0000\u00c8\u00c9\u0005o\u0000\u0000\u00c9\u00ca\u0005r\u0000\u0000\u00ca"+
		"\u0016\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005i\u0000\u0000\u00cc\u00cd"+
		"\u0005f\u0000\u0000\u00cd\u0018\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		"r\u0000\u0000\u00cf\u00d0\u0005e\u0000\u0000\u00d0\u00d1\u0005t\u0000"+
		"\u0000\u00d1\u00d2\u0005u\u0000\u0000\u00d2\u00d3\u0005r\u0000\u0000\u00d3"+
		"\u00d4\u0005n\u0000\u0000\u00d4\u001a\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0005w\u0000\u0000\u00d6\u00d7\u0005h\u0000\u0000\u00d7\u00d8\u0005i"+
		"\u0000\u0000\u00d8\u00d9\u0005l\u0000\u0000\u00d9\u00da\u0005e\u0000\u0000"+
		"\u00da\u001c\u0001\u0000\u0000\u0000\u00db\u00dc\u0005t\u0000\u0000\u00dc"+
		"\u00dd\u0005r\u0000\u0000\u00dd\u00de\u0005u\u0000\u0000\u00de\u00df\u0005"+
		"e\u0000\u0000\u00df\u001e\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005f\u0000"+
		"\u0000\u00e1\u00e2\u0005a\u0000\u0000\u00e2\u00e3\u0005l\u0000\u0000\u00e3"+
		"\u00e4\u0005s\u0000\u0000\u00e4\u00e5\u0005e\u0000\u0000\u00e5 \u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005n\u0000\u0000\u00e7\u00e8\u0005e\u0000"+
		"\u0000\u00e8\u00e9\u0005w\u0000\u0000\u00e9\"\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0005t\u0000\u0000\u00eb\u00ec\u0005h\u0000\u0000\u00ec\u00ed"+
		"\u0005i\u0000\u0000\u00ed\u00ee\u0005s\u0000\u0000\u00ee$\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005c\u0000\u0000\u00f0\u00f1\u0005l\u0000\u0000"+
		"\u00f1\u00f2\u0005a\u0000\u0000\u00f2\u00f3\u0005s\u0000\u0000\u00f3\u00f4"+
		"\u0005s\u0000\u0000\u00f4&\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005n"+
		"\u0000\u0000\u00f6\u00f7\u0005u\u0000\u0000\u00f7\u00f8\u0005l\u0000\u0000"+
		"\u00f8\u00f9\u0005l\u0000\u0000\u00f9(\u0001\u0000\u0000\u0000\u00fa\u00fb"+
		"\u0005(\u0000\u0000\u00fb*\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005)"+
		"\u0000\u0000\u00fd,\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005[\u0000\u0000"+
		"\u00ff.\u0001\u0000\u0000\u0000\u0100\u0101\u0005]\u0000\u0000\u01010"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0005{\u0000\u0000\u01032\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0005}\u0000\u0000\u01054\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005<\u0000\u0000\u01076\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0005<\u0000\u0000\u0109\u010a\u0005=\u0000\u0000\u010a8\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0005>\u0000\u0000\u010c:\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0005>\u0000\u0000\u010e\u010f\u0005=\u0000\u0000\u010f<"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0005<\u0000\u0000\u0111\u0112\u0005"+
		"<\u0000\u0000\u0112>\u0001\u0000\u0000\u0000\u0113\u0114\u0005>\u0000"+
		"\u0000\u0114\u0115\u0005>\u0000\u0000\u0115@\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0005+\u0000\u0000\u0117B\u0001\u0000\u0000\u0000\u0118\u0119\u0005"+
		"+\u0000\u0000\u0119\u011a\u0005+\u0000\u0000\u011aD\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0005-\u0000\u0000\u011cF\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0005-\u0000\u0000\u011e\u011f\u0005-\u0000\u0000\u011fH\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005*\u0000\u0000\u0121J\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0005/\u0000\u0000\u0123L\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0005%\u0000\u0000\u0125N\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"&\u0000\u0000\u0127P\u0001\u0000\u0000\u0000\u0128\u0129\u0005|\u0000"+
		"\u0000\u0129R\u0001\u0000\u0000\u0000\u012a\u012b\u0005&\u0000\u0000\u012b"+
		"\u012c\u0005&\u0000\u0000\u012cT\u0001\u0000\u0000\u0000\u012d\u012e\u0005"+
		"|\u0000\u0000\u012e\u012f\u0005|\u0000\u0000\u012fV\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0005^\u0000\u0000\u0131X\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0005!\u0000\u0000\u0133Z\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"~\u0000\u0000\u0135\\\u0001\u0000\u0000\u0000\u0136\u0137\u0005?\u0000"+
		"\u0000\u0137^\u0001\u0000\u0000\u0000\u0138\u0139\u0005:\u0000\u0000\u0139"+
		"`\u0001\u0000\u0000\u0000\u013a\u013b\u0005;\u0000\u0000\u013bb\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005,\u0000\u0000\u013dd\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u0005=\u0000\u0000\u013ff\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0005=\u0000\u0000\u0141\u0142\u0005=\u0000\u0000\u0142h\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005!\u0000\u0000\u0144\u0145\u0005=\u0000"+
		"\u0000\u0145j\u0001\u0000\u0000\u0000\u0146\u0147\u0005-\u0000\u0000\u0147"+
		"\u0148\u0005>\u0000\u0000\u0148l\u0001\u0000\u0000\u0000\u0149\u014a\u0005"+
		".\u0000\u0000\u014an\u0001\u0000\u0000\u0000\u014b\u0150\u0003q8\u0000"+
		"\u014c\u014f\u0003q8\u0000\u014d\u014f\u0003w;\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0152\u0001"+
		"\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151\u0001"+
		"\u0000\u0000\u0000\u0151p\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0003s9\u0000\u0154r\u0001\u0000\u0000\u0000"+
		"\u0155\u0156\u0007\u0000\u0000\u0000\u0156t\u0001\u0000\u0000\u0000\u0157"+
		"\u0158\u0007\u0001\u0000\u0000\u0158v\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0007\u0002\u0000\u0000\u015ax\u0001\u0000\u0000\u0000\u015b\u015c\u0007"+
		"\u0003\u0000\u0000\u015cz\u0001\u0000\u0000\u0000\u015d\u015f\u0003w;"+
		"\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000"+
		"\u0000\u0161|\u0001\u0000\u0000\u0000\u0162\u0163\u0005\\\u0000\u0000"+
		"\u0163\u0164\u0007\u0004\u0000\u0000\u0164~\u0001\u0000\u0000\u0000\u0165"+
		"\u0168\u0007\u0005\u0000\u0000\u0166\u0168\u0003}>\u0000\u0167\u0165\u0001"+
		"\u0000\u0000\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u0080\u0001"+
		"\u0000\u0000\u0000\u0169\u016b\u0007\u0006\u0000\u0000\u016a\u0169\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016a\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001"+
		"\u0000\u0000\u0000\u016e\u016f\u0006@\u0000\u0000\u016f\u0082\u0001\u0000"+
		"\u0000\u0000\u0170\u0172\u0005\r\u0000\u0000\u0171\u0173\u0005\n\u0000"+
		"\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000"+
		"\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0176\u0005\n\u0000\u0000"+
		"\u0175\u0170\u0001\u0000\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000"+
		"\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0006A\u0000\u0000\u0178"+
		"\u0084\u0001\u0000\u0000\u0000\u0179\u017a\u0005/\u0000\u0000\u017a\u017b"+
		"\u0005/\u0000\u0000\u017b\u017f\u0001\u0000\u0000\u0000\u017c\u017e\b"+
		"\u0007\u0000\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017e\u0181\u0001"+
		"\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u017f\u0180\u0001"+
		"\u0000\u0000\u0000\u0180\u0182\u0001\u0000\u0000\u0000\u0181\u017f\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0006B\u0000\u0000\u0183\u0086\u0001\u0000"+
		"\u0000\u0000\r\u0000\u008b\u008f\u0095\u009c\u014e\u0150\u0160\u0167\u016c"+
		"\u0172\u0175\u017f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}