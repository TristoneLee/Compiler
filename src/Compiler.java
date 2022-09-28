package src;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

import src.antlr.gen.*;


public class Compiler {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        CharStream charStream = CharStreams.fromStream(inputStream);
        MxLexer lexer = new MxLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        MxParserListener listener=new MxParserBaseListener();

    }
}
