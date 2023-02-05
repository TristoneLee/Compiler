package ASM;

import IR.IRBuilder;
import IR.IRUtility.IRVar;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ASMBuilder {
    LinkedList<ASMFunction> funcs=new LinkedList<>();
    LinkedList<IRVar> globVars=new LinkedList<>();
    LinkedList<IRVar> strConsts=new LinkedList<>();
    int callArgStackOffset=0;
    int stackOffset=0;
    PrintStream out;
    public Map<String,IRVar> constStringMap=new LinkedHashMap<>();

    public ASMBuilder(IRBuilder ir) {
        var irFuncs = ir.funcs;
        var irGlobVars = ir.globVars;
        irFuncs.forEach((name, func) -> {
            funcs.add(new ASMFunction(func));
        });
        globVars=ir.globVars;
        constStringMap=ir.constStringMap;
    }

    public void setStream(PrintStream out_) {
        out = out_;
    }

    public void print() {
        out.print(
                "\t.text\n" +
                "\t.align 2\n" +
                "\n");
        for(var func:funcs){
            out.println("\t.globl "+func.funcName);
            out.println(func.funcName+":");
            for(var block:func.blocks){
                out.print("."+block.id()+":\n");
                for(var ins:block.block) out.println("\t"+ins.toString());
            }
            out.print('\n');
        }
        out.print("\t.section\t.data\n");
        for(var globVar:globVars){
            out.printf("\t.globl %s\n%s:\n\t.word\t0\n",globVar.name,globVar.name);
        }
        out.print("\t.section .rodata\n");
        constStringMap.forEach((s,var)->{
            out.printf("%s:\n\t.string\t%s\n", toLiteral(var.name),s);
        });
    }

    String toLiteral(String val) {
        String ret = "";
        for (var ch: val.toCharArray()) {
            switch (ch) {
                case '\n':
                    ret += "\\n";
                    break;
                case '\"':
                    ret += "\\\"";
                    break;
                case '\\':
                    ret += "\\\\";
                    break;
                default:
                    ret+=(ch);
            }
        }
        return ret;
    }

}
