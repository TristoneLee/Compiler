package AST;

import parser.ClassEntity;
import parser.FunctionEntity;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidStmt;
import utility.Exception.Redeclarification;
import utility.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ASNClassDel extends ASNStmt {
    public ASNClassConstructorDec constructorDec;
    public List<ASNFuncDec> classMethods;
    public ClassEntity classEntity;

    public ASNClassDel(ScopeBuffer scopeBuffer) {
        super("ClassDec", scopeBuffer);
        classEntity=new ClassEntity();
        classMethods=new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNFuncDec) {
                classMethods.add((ASNFuncDec) child);
                classEntity.classMethod.put(((ASNFuncDec) child).entity.functionName,((ASNFuncDec) child).entity);
            }
            else if (child instanceof ASNClassConstructorDec) {
                if(!Objects.equals(((ASNClassConstructorDec) child).className, classEntity.className)) throw new InvalidStmt();
                constructorDec = (ASNClassConstructorDec) child;
            }
            else if (child instanceof ASNClassMemberDec) {
                for(Parameter member:((ASNClassMemberDec) child).members){
                    if(classEntity.classMember.containsKey(member.name)) throw new Redeclarification(member.name);
                    else classEntity.classMember.put(member.name,member);
                }
            }
            else if (child instanceof ASNIdentifier ){
                classEntity.className=((ASNIdentifier) child).identifier;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        if(constructorDec!=null&&!Objects.equals(constructorDec.className, classEntity.className)) throw new CompileException("UnmatchedConstructor");
        scopeBuffer.push(new Scope(classEntity));
        scopeBuffer.controlFlow.push(this);
        for(ASNFuncDec method:classMethods) method.check();
        if(constructorDec!=null)constructorDec.check();
        scopeBuffer.controlFlow.pop();
        scopeBuffer.pop();
    }
}
