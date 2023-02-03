import java.io.*;

import ASM.ASMBuilder;
import IR.IRBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.MxLexer;
import antlr.MxParser;
import parser.ASTbuilder;
import utility.BuildInPrinter;
import utility.Exception.CompileException;
import utility.MxErrorListener;

public class Compiler {

    public static void main(String[] args) throws Exception {
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
            var output=new PrintStream("output.s");
            var asmBuilder=new ASMBuilder(irBuilder);
            asmBuilder.setStream(output);
            asmBuilder.print();
            var buildInPrinter=new BuildInPrinter(new PrintStream("buildin.s"));
            buildInPrinter.print();
//            System.out.println("Success!");
        }catch (CompileException exception){
            exception.Call();
            throw new Exception();
        }
//        catch (RuntimeException e){
//            System.err.println(e.getMessage());
//            throw new Exception();
//        }
    }
}
