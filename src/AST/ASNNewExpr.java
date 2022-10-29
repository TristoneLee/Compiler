package src.AST;

import src.parser.ClassEntity;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ASNNewExpr extends ASNExpr{
    ASNTypeSpecifier expr;
    public ASNNewExpr(ScopeBuffer scopeBuffer){
        super("NewExpr",scopeBuffer);
    }
    @Override
    public void build(){
        expr= (ASNTypeSpecifier) children.get(0);
    }
    @Override
    public void check() throws CompileException {
        expr.check();
        String _baseType=expr.valueType.baseType;
        if(Objects.equals(_baseType, "string") || Objects.equals(_baseType, "int") || Objects.equals(_baseType, "bool")) returnType=expr.valueType;
        else {
            ClassEntity entity=scopeBuffer.searchClass(expr.valueType.baseType);
            if(entity==null) throw new CompileException("UndefinedClass");
            else returnType=expr.valueType;
        }
    }
}
