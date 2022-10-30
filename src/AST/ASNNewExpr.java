package AST;

import parser.ClassEntity;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ASNNewExpr extends ASNExpr{
    ASNNewTypeSpecifier expr;
    ASNIdentifier expr_;
    public ASNNewExpr(ScopeBuffer scopeBuffer){
        super("NewExpr",scopeBuffer);
    }
    @Override
    public void build(){
        if(children.get(0) instanceof ASNNewTypeSpecifier) expr= (ASNNewTypeSpecifier) children.get(0);
        else expr_= (ASNIdentifier)children.get(0);
    }
    @Override
    public void check() throws CompileException {
        if(expr!=null){
        expr.check();
        String _baseType=expr.returnType.baseType;
        if(Objects.equals(_baseType, "string") || Objects.equals(_baseType, "int") || Objects.equals(_baseType, "bool")) returnType=expr.returnType;
        else {
            ClassEntity entity=scopeBuffer.searchClass(expr.returnType.baseType);
            if(entity==null) throw new CompileException("UndefinedClass");
            else returnType=expr.returnType;
        }
        }
        else {
            ClassEntity classEntity=scopeBuffer.searchClass(expr_.identifier);
            if(classEntity==null) throw new CompileException("UndefinedClass");
            returnType=new ValueType(expr_.identifier);
        }
    }
}
