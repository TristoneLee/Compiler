package src.AST;

import com.sun.jdi.VoidType;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.ValueType;
import src.utility.ValueType.*;

import java.util.ArrayList;
import java.util.List;

public class ASNVarDec extends ASNStmt{
    ValueType valueType;
    List<ASNInitDeclarator> declarators=new ArrayList<>();
    public ASNVarDec(ScopeBuffer scopeBuffer){
        super("VarDec",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        for(ASN child:children){
            if(child instanceof ASNTypeSpecifier){
                valueType=((ASNTypeSpecifier)child).valueType;
            }else if(child instanceof ASNInitDeclarator){
                declarators.add((ASNInitDeclarator) child);
            }
        }
    }

    @Override
    public void check() throws CompileException {
        for(ASNInitDeclarator declarator:declarators){
            declarator.check();
            if(valueType.equals(ValueType.VoidType)) throw new CompileException("ValidValueType");
            if(declarator.initor!=null&&!valueType.equals(declarator.returnType)) throw new CompileException("UnmatchedValueType");
            scopeBuffer.addVariable(declarator.name,valueType);
        }
    }
}
