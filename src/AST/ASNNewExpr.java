package AST;

import parser.ClassEntity;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ASNNewExpr extends ASNExpr{
    ASNTypeSpecifier expr;
    ASNIdentifier expr_;
    public ASNNewExpr(ScopeBuffer scopeBuffer){
        super("NewExpr",scopeBuffer);
    }
    @Override
    public void build(){
        if(children.get(0) instanceof ASNTypeSpecifier) expr= (ASNTypeSpecifier) children.get(0);
        else expr_= (ASNIdentifier)children.get(0);
    }
    @Override
    public void check() throws CompileException {
        if(expr!=null){
        expr.check();
        String _baseType=expr.valueType.baseType;
        if(Objects.equals(_baseType, "string") || Objects.equals(_baseType, "int") || Objects.equals(_baseType, "bool")) returnType=expr.valueType;
        else {
            ClassEntity entity=scopeBuffer.searchClass(expr.valueType.baseType);
            if(entity==null) throw new CompileException("UndefinedClass");
            else returnType=expr.valueType;
        }
        }
        else {
            expr_.check();
            returnType=expr_.returnType;
        }
    }
}
