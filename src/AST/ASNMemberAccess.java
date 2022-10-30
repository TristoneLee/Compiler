package AST;

import parser.ClassEntity;
import parser.FunctionEntity;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.ValueType;

public class ASNMemberAccess extends ASNExpr {
    ASNExpr var;
    ASNExpr postfix;

    public ASNMemberAccess(ScopeBuffer scopeBuffer) {
        super("MemberAccess", scopeBuffer);
    }

    @Override
    public void build() {
        var = (ASNExpr) children.get(0);
        postfix = (ASNExpr) children.get(1);
    }

    @Override
    public void check() throws CompileException {
        var.check();
        if (var.returnType.dimension == 0) {
            ClassEntity entity = scopeBuffer.searchClass(var.returnType.baseType);
            if (entity == null) throw new InvalidExpression();
            scopeBuffer.push(new Scope(entity));
        } else scopeBuffer.push(new Scope(ClassEntity.arrayClass));
        postfix.check();
        scopeBuffer.pop();
        returnType = postfix.returnType;
        ifLeftValue=postfix.ifLeftValue;
    }
}
