import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import IR.IRBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.MxLexer;
import antlr.MxParser;
import parser.ASTbuilder;
import utility.Exception.CompileException;
import utility.MxErrorListener;

public class Compiler {

    public static void main(String[] args) throws Exception {
//        FileInputStream fis;
//        {
//            try {
//                fis = new FileInputStream("E:\\课程资料\\大二上\\编译器\\Compiler-Design-Implementation\\Compiler-2021-testcases\\sema\\basic-package\\basic-2.mx");
//                System.setIn(fis);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            CharStream charStream = CharStreams.fromStream(System.in);
            MxLexer lexer = new MxLexer(charStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxParser parser = new MxParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree tree = parser.translationUnit();
            ParseTreeWalker walker = new ParseTreeWalker();
            ASTbuilder astBuilder = new ASTbuilder();
            walker.walk(astBuilder, tree);
            astBuilder.check();
            var irBuilder= new IRBuilder(astBuilder);
            irBuilder.print();
//            System.out.println("Success!");
        }catch (CompileException exception){
            exception.Call();
            throw new Exception();
        }
//        catch (RuntimeException e){
//            System.err.println(e.getMessage());
//            throw new Exception();
//
//        }
    }
}
