package src.parser;

import src.AST.*;

import java.util.Stack;

public class ASTbuilder {
    Stack<ASN> buffer;
    ASN root;

    public void push (ASN node){
        node.setParent(buffer.peek());
        buffer.push(node);
    }

    public void pop (){
        if(buffer.size()==1){
            root= buffer.peek();
            buffer.pop();
            return;
        }
        ASN tem=buffer.pop();
        buffer.peek().attachChild(tem);
    }
}
