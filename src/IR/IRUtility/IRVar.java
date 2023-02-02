package IR.IRUtility;

/*
A pair used to denote the value in IR distinguishing immediate number and value in reg
 */


public class IRVar {
    public enum IRVarGenre {GLOBAL, LOCAL, LITERAL}


    public IRType type = null;
    public IRVarGenre genre;
    public String name = null;
    public int index = -1;
    public Integer literal = null;


    public IRVar(IRVarGenre genre_) {
        genre = genre_;
    }

    public IRVar(IRType irType, int index_) {
        genre = IRVarGenre.LOCAL;
        index = index_;
        type = irType;
    }

    public IRVar(IRType irType, String name_) {
        genre = IRVarGenre.GLOBAL;
        name = name_;
        type = irType;
    }

    public IRVar(IRType irType, String name_, int dim) {
        genre = IRVarGenre.GLOBAL;
        name = name_;
        type = irType;
    }

    public IRVar(int literal_, IRType.Genre genre_) {
        genre=IRVarGenre.LITERAL;
        type = new IRType(genre_);
        literal = literal_;
    }

    public IRVar(IRVar rhs) {
        if(rhs==null) return;
        type = new IRType(rhs.type, false);
        genre = rhs.genre;
        name = rhs.name;
        index = rhs.index;
        literal = rhs.literal;
    }

    public String toString() {
        if (genre == IRVarGenre.LOCAL) {
            return type.toString() + " %" + index;
        } else if (genre == IRVarGenre.GLOBAL) {
            return type.toString() + " @" + name;
        } else {
            return type.toString() + " " + literal.toString();
        }
    }

}
