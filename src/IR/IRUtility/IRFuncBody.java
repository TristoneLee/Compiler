package IR.IRUtility;

import AST.ASNFuncBody;
import AST.ASNStmt;
import IR.IRBlock;

import java.util.ArrayList;
import java.util.List;
public class IRFuncBody {
    List<IRBlock> blocks;
    Integer localVarIndex;

    public IRFuncBody(ASNFuncBody funcBody){
        blocks=new ArrayList<>();
        blocks.add(new IRBlock());
        localVarIndex=0;
        funcBody.irGeneration(blocks,localVarIndex,0);
    }
}
