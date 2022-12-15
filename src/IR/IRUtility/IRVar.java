package IR.IRUtility;

/*
A pair used to denote the value in IR distinguishing immediate number and value in reg
 */

import com.sun.jdi.Value;
import utility.Parameter;
import utility.ValueType;

import static IR.IRUtility.IRType.i32;

public class IRVar {
    public enum IRVarGenre {global, local, literal}

    public IRType type = null;
    public IRVarGenre genre;
    public String name = null;
    public int index = -1;
    public Integer literal = null;
    public int length=1;

    public IRVar(ValueType valueType, int index_) {
        genre = IRVarGenre.local;
        index = index_;
        type = new IRType(valueType);
    }

    public IRVar(ValueType valueType, int index_,int ptrRank) {
        genre = IRVarGenre.local;
        index = index_;
        type = new IRType(valueType);
    }

    public IRVar(ValueType valueType, String name_) {
        genre = IRVarGenre.global;
        name = name_;
        type = new IRType(valueType);
    }

    public IRVar(ValueType valueType, String name_,int ptrRank) {
        genre = IRVarGenre.global;
        name = name_;
        type = new IRType(valueType);
    }

    public IRVar(int literal_) {
        type = new IRType(i32,false);
        literal = literal_;
    }

    public IRVar(IRVar rhs) {
        type = new IRType(rhs.type,false);
        genre = rhs.genre;
        name = rhs.name;
        index = rhs.index;
        literal = rhs.literal;
    }

    public String toString(){
        if(genre==IRVarGenre.local){
            return "%"+ index;
        }else if(genre==IRVarGenre.global){
            return "@"+name;
        }else {
            return literal.toString();
        }
    }

}
