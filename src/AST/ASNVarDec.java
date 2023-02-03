package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRAlloca;
import IR.IRIns.IRLoad;
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
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        IRType irType = new IRType(valueType,irBuilder);
        for (ASNInitDeclarator declarator : declarators) {
            irFunction.localVarIndex++;
            IRVar curVar = new IRVar(new IRType(valueType,irBuilder).set_ptr(), irFunction.localVarIndex);
            irBuilder.irScopeStack.scopeStack.peek().indexTable.put(declarator.name, curVar);
            irFunction.addIns(new IRAlloca(curVar));
            if (declarator.initor != null) {
                var rhsVar = declarator.initor.irGeneration(irBuilder, irFunction);
                if((declarator.initor instanceof ASNMemberAccess&& !( ((ASNMemberAccess) declarator.initor).postfix instanceof ASNFuncCall))||declarator.initor instanceof ASNArrayAccess){
                    var loadIns=new IRLoad();
                    loadIns.src=rhsVar;
                    ++irFunction.localVarIndex;
                    loadIns.des=new IRVar(curVar.type.deref(), irFunction.localVarIndex);
                    rhsVar=loadIns.des;
                    irFunction.addIns(loadIns);
                }
                irFunction.addIns(new IRStore(curVar, rhsVar));
            }
        }
        return null;
    }

    public void globalInitGeneration(IRBuilder irBuilder,IRFunction irFunction){
            IRType irType = new IRType(valueType,irBuilder);
            irType.dim++;
            for (ASNInitDeclarator declarator : declarators) {
                IRVar curVar = new IRVar(irType, declarator.name);
                irBuilder.globVars.add(curVar);
                irBuilder.irScopeStack.globScope().indexTable.put(declarator.name, curVar);
                if (declarator.initor != null) {
                    var rhsVar = declarator.initor.irGeneration(irBuilder, irFunction);
                    if((declarator.initor instanceof ASNMemberAccess&& !( ((ASNMemberAccess) declarator.initor).postfix instanceof ASNFuncCall))||declarator.initor instanceof ASNArrayAccess){
                        var loadIns=new IRLoad();
                        loadIns.src=rhsVar;
                        ++irFunction.localVarIndex;
                        loadIns.des=new IRVar(curVar.type.deref(), irFunction.localVarIndex);
                        rhsVar=loadIns.des;
                        irFunction.addIns(loadIns);
                    }
                    irFunction.addIns(new IRStore(curVar, rhsVar));
                }
            }
    }
}
