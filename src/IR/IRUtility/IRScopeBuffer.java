package IR.IRUtility;

import parser.Scope;

import java.util.Stack;

public class IRScopeBuffer {
    public Stack<IRScope> scopeBuffer;

     public int searchVarIndex(String varName){
         for (int i = scopeBuffer.size() - 1; i >= 0; --i) {
             IRScope scope = scopeBuffer.get(i);
             if (scope.indexTable.containsKey(varName)) return scope.indexTable.get(varName);
         }
         return -1;
     }
}
