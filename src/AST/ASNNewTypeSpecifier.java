package AST;

import IR.IRUtility.IRType;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidArrayType;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

public class ASNNewTypeSpecifier extends ASNExpr {
    String baseType;
    int dimension;
    List<ASNExpr> indexes;
    int newDim = 0;

    public ASNNewTypeSpecifier(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        indexes = new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst) baseType = ((ASNStringConst) child).value;
            else if (child instanceof ASNNewArrayUni) {
                ++dimension;
                indexes.add(((ASNNewArrayUni) child).expr);
                if (((ASNNewArrayUni) child).expr == null)++newDim;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        if (baseType.equals("void") && dimension != 0) throw new InvalidArrayType();
        boolean flag = false;
        for (ASNExpr dim : indexes) {
            if(dim!=null) dim.check();
            if(dim!=null&&!dim.returnType.equals(ValueType.IntegerType)) throw new InvalidArrayType();
            if (dim == null) flag = true;
            else if (flag) throw new InvalidArrayType();
        }
        returnType = new ValueType(baseType);
        returnType.dimension = dimension;
        for (int i = 0; i < dimension; ++i) returnType.dimensions.add(0);
    }
}

