package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidArrayType;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

public class ASNNewTypeSpecifier extends ASNExpr{
    String baseType;
    int dimension;
    List<ASNExpr> dimensions;

    public ASNNewTypeSpecifier(ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
        dimensions=new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst) baseType = ((ASNStringConst) child).value;
            else if (child instanceof ASNNewArrayUni) {
                ++dimension;
                dimensions.add(((ASNNewArrayUni) child).expr);
            }
        }
    }

    @Override
    public void check() throws CompileException {
        if (baseType.equals("void") && dimension != 0) throw new InvalidArrayType();
        boolean flag = false;
        for (ASNExpr expr : dimensions) {
            if(expr!=null){
                expr.check();
                if(!expr.returnType.equals(ValueType.IntegerType)) throw new CompileException("InvalidArrayNew");
            }
            if (expr == null) flag = true;
            else if (flag) throw new InvalidArrayType();
        }
        returnType=new ValueType(baseType);
        returnType.dimension=dimension;
        for(int i=0;i<dimension;++i)returnType.dimensions.add(0);
    }
}

