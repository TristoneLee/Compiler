package src.AST;

import src.parser.ClassEntity;
import src.parser.FunctionEntity;
import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidStmt;
import src.utility.Exception.Redeclarification;
import src.utility.Parameter;

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
                if(((ASNClassConstructorDec) child).className!= classEntity.className) throw new InvalidStmt();
                constructorDec = (ASNClassConstructorDec) child;
            }
            else if (child instanceof ASNClassMemberDec) {
                for(Parameter member:((ASNClassMemberDec) child).members){
                    if(classEntity.classMember.containsKey(member.name)) throw new Redeclarification(member.name);
                    else classEntity.classMember.put(member.name,member);
                }
            }
            else if (child instanceof ASNStringConst ){
                classEntity.className=((ASNStringConst) child).value;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        if(constructorDec!=null&&!Objects.equals(constructorDec.className, classEntity.className)) throw new CompileException("UnmatchedConstructor");
        scopeBuffer.push(new Scope(classEntity));
        for(ASNFuncDec method:classMethods) method.check();
        if(constructorDec!=null)constructorDec.check();
        scopeBuffer.pop();
    }
}
