package IR.IRUtility;

import java.util.Stack;

public class IRScopeStack {
    public Stack<IRScope> scopeStack;

     public IRVar searchVar(String varName){
         for (int i = scopeStack.size() - 1; i >= 0; --i) {
             IRScope scope = scopeStack.get(i);
             if (scope.indexTable.containsKey(varName)) return scope.indexTable.get(varName);
         }
         return null;
     }

     public void push(){
         scopeStack.push(new IRScope());
     }

     public void pop(){
         scopeStack.pop();
     }
}
