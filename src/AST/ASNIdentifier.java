package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRGetPtr;
import IR.IRIns.IRLoad;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.UndeifinedVariety;

import java.util.concurrent.atomic.AtomicReference;

public class ASNIdentifier extends ASNExpr{
    String identifier;

    public ASNIdentifier(String text, ScopeBuffer scopeBuffer){
        super(scopeBuffer);
        identifier=text;
        ifLeftValue=true;
    }

    @Override
    public void build() throws CompileException {
        super.build();
    }

    @Override
    public void check() throws CompileException {
        returnType=scopeBuffer.searchVar(identifier);
        if(returnType==null) throw new UndeifinedVariety();
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        IRVar returnVar= irBuilder.irScopeStack.searchVar(identifier);
        if(returnVar ==null&&irFunction.ifMethod){
            for(var pair:irFunction.struct.memberList.entrySet()){
                if(pair.getKey().equals(identifier)){
                    var getPtrIns=new IRGetPtr();
                    ++irFunction.localVarIndex;
                    returnVar=getPtrIns.des = new IRVar(pair.getValue(), irFunction.localVarIndex);
                    getPtrIns.src=irFunction.paras.get(0);
                    getPtrIns.structOffset=irFunction.struct.getMemberOffset(identifier);
                    getPtrIns.indexes.add(new IRVar(0, IRType.Genre.I32));
                    getPtrIns.indexes.add(new IRVar(irFunction.struct.getMemberIndex(identifier), IRType.Genre.I32));
                    irFunction.addIns( getPtrIns);
                }
            }
        }
        if(ifLoad){
            var srcVar=returnVar;
            var loadIns=new IRLoad();
            ++irFunction.localVarIndex;
            loadIns.des= new IRVar(srcVar.type.deref(), irFunction.localVarIndex);
            loadIns.src=srcVar;
            irFunction.addIns( loadIns);
            return loadIns.des;
        }
        else return returnVar;
    }
}
