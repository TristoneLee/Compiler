package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRAlloca;
import IR.IRIns.IRStore;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

public class ASNVarDec extends ASNStmt {
    ValueType valueType;
    List<ASNInitDeclarator> declarators = new ArrayList<>();

    public ASNVarDec(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNTypeSpecifier) {
                valueType = ((ASNTypeSpecifier) child).valueType;
            } else if (child instanceof ASNInitDeclarator) {
                declarators.add((ASNInitDeclarator) child);
            }
        }
    }

    @Override
    public void check() throws CompileException {
        for (ASNInitDeclarator declarator : declarators) {
            declarator.check();
            if (valueType.equals(ValueType.VoidType)) throw new CompileException("ValidValueType");
            if (declarator.initor != null && !valueType.equals(declarator.returnType) && !(!valueType.isBasicType() && declarator.returnType.equals(ValueType.NullType)))
                throw new CompileException("UnmatchedValueType");
            scopeBuffer.addVariable(declarator.name, valueType);
        }
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        IRType irType = new IRType(valueType);
        for (ASNInitDeclarator declarator : declarators) {
            irFunction.localVarIndex++;
            IRVar curVar = new IRVar(valueType, irFunction.localVarIndex, valueType.isBasicType() ? 0 : 1);
            irBuilder.irScopeStack.scopeStack.peek().indexTable.put(declarator.name, curVar);
            irFunction.blocks.get(curBlock).ins.add(new IRAlloca(curVar));
            if (declarator.initor != null) {
                var rhsVar = declarator.initor.irGeneration(irBuilder, irFunction, curBlock);
                irFunction.blocks.get(curBlock).ins.add(new IRStore(curVar, new IRVar(valueType, rhsVar.index)));
            }
        }
        return null;
    }
}
