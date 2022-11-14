package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ASNClassMemberDec extends ASNStmt{
    ValueType valueType;
    List<Parameter> members;

    public ASNClassMemberDec(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
        members=new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for(ASN child:children){
            if(child instanceof ASNTypeSpecifier) valueType=((ASNTypeSpecifier) child).valueType;
            else if(child instanceof ASNStringConst) members.add(new Parameter(((ASNStringConst) child).value,valueType));
        }
    }

    @Override
    public void check() throws CompileException {
        super.check();
    }
}
