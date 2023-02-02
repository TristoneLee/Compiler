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
        AtomicReference<IRVar> returnVar= new AtomicReference<>(irBuilder.irScopeStack.searchVar(identifier));
        if(returnVar.get() ==null&&irFunction.ifMethod){
            irFunction.struct.memberList.forEach((member,type)->{
                if(member.equals(identifier)){
                    var getPtrIns=new IRGetPtr();
                    ++irFunction.localVarIndex;
                    returnVar.set(getPtrIns.des = new IRVar(type, irFunction.localVarIndex));
                    getPtrIns.src=irFunction.paras.get(0);
                    getPtrIns.indexes.add(new IRVar(0, IRType.Genre.I32));
                    getPtrIns.indexes.add(new IRVar(irFunction.struct.getMemberIndex(identifier), IRType.Genre.I32));
                    irFunction.addIns(irFunction.curBlock, getPtrIns);
                }
            });
        }
        if(ifLoad){
            var srcVar=returnVar.get();
            var loadIns=new IRLoad();
            ++irFunction.localVarIndex;
            loadIns.des= new IRVar(srcVar.type.deref(), irFunction.localVarIndex);
            loadIns.src=srcVar;
            irFunction.addIns(irFunction.curBlock, loadIns);
            return loadIns.des;
        }
        else return returnVar.get();
    }
}
