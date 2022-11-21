package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import com.sun.jdi.VoidType;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;
import utility.ValueType.*;

import java.util.ArrayList;
import java.util.List;

public class ASNVarDec extends ASNStmt{
    ValueType valueType;
    List<ASNInitDeclarator> declarators=new ArrayList<>();
    public ASNVarDec(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
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
            if(declarator.initor!=null&&!valueType.equals(declarator.returnType)&&!(!valueType.isBasicType()&&declarator.returnType.equals(ValueType.NullType))) throw new CompileException("UnmatchedValueType");
            scopeBuffer.addVariable(declarator.name,valueType);
        }
    }

    @Override
    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        if (valueType.equals(ValueType.IntegerType)) {
            localVarIndex++;
            blocks.get(curBlock).ins.add(new IR)
        }
        return 0;
    }
}
