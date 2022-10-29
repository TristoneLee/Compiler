package src;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import src.antlr.*;
import src.parser.ASTbuilder;
import src.utility.Exception.CompileException;


public class Compiler {

    public static void main(String[] args) throws IOException {
        FileInputStream fis;
        {
            try {
                fis = new FileInputStream("E:\\课程资料\\大二上\\编译器\\Compiler-Design-Implementation\\testcases\\sema\\basic-package\\basic-55.mx");
                System.setIn(fis);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            CharStream charStream = CharStreams.fromStream(System.in);
            MxLexer lexer = new MxLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxParser parser = new MxParser(tokens);
            ParseTree tree = parser.translationUnit();
            ParseTreeWalker walker = new ParseTreeWalker();
            ASTbuilder builder = new ASTbuilder();
            walker.walk(builder, tree);
            builder.check();
            System.out.println("Success!");
        }catch (CompileException exception){
            exception.Call();
        }
    }
}
