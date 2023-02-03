package IR.IRUtility;

import IR.IRBuilder;
import IR.IRStruct;
import utility.ValueType;

public class IRType {
    public enum Genre {
        I1, I8, I32, VOID, STRUCT
    }

    public Genre genre;
    public int dim = 0;
    public int size = 0;
    boolean ifStruct;
    public IRStruct tarStruct;

    public IRType(Genre genre_) {
        genre = genre_;
        dim = 0;
    }

    public IRType(ValueType valueType, IRBuilder irBuilder) {
        if (valueType.baseType.equals("int")) {
            genre = Genre.I32;
        } else if (valueType.baseType.equals("bool")) {
            genre = Genre.I1;
        } else if (valueType.baseType.equals("string")) {
            genre = Genre.I8;
            dim++;
        } else if (valueType.baseType.equals("void")) {
            genre = Genre.VOID;
        } else {
            genre = Genre.STRUCT;
            ifStruct = true;
            dim++;
            tarStruct=irBuilder.searchStruct(valueType.baseType);
        }
        dim += valueType.dimension;
    }

    public IRType(IRType rhs, boolean ifPtr_) {
        this.genre = rhs.genre;
        this.ifStruct = rhs.ifStruct;
        this.tarStruct = rhs.tarStruct;
        this.dim = ifPtr_ ? rhs.dim + 1 : rhs.dim;
    }

    public IRType(IRType rhs) {
        this.genre = rhs.genre;
        this.ifStruct = rhs.ifStruct;
        this.tarStruct = rhs.tarStruct;
        this.dim = rhs.dim;
        this.size = rhs.size;
    }

    public  IRType set_ptr() {
        dim++;
        return this;
    }

    public IRType deref() {
        var returnType = new IRType(this);
        if (returnType.dim > 0) returnType.dim--;
        return returnType;
    }

    public String toString() {
        StringBuilder typeString = new StringBuilder();
        switch (genre) {
            case I1 -> typeString.append("i1");
            case I8 -> typeString.append("i8");
            case I32 -> typeString.append("i32");
            case VOID -> typeString.append("void");
            case STRUCT -> typeString.append("%class.").append(tarStruct.structName);
        }
        if (size == 0) // Pointer instead of Array
            typeString.append("*".repeat(dim));
        else // ! Only i8 Array
            return String.format("[%d x i8]", size)
                    + "*".repeat(dim);
        return typeString.toString();
    }

    static public IRType new_i32() {
        return new IRType(Genre.I32);
    }

    static public IRType new_i8() {
        return new IRType((Genre.I8));
    }

    static public IRType new_i1() {
        return new IRType(Genre.I1);
    }

    static public IRType new_i32ptr() {
        return new IRType(Genre.I32).set_ptr();
    }

    static public IRType new_i8_ptr() {
        return new IRType(Genre.I8).set_ptr();
    }

    static public IRType new_i1_ptr() {
        return new IRType(Genre.I1).set_ptr();
    }

    static public int i8_size=4;
    static public int i32_size=4;
    static public int i1_size=4;
    static public int prt_size=4;

    public int getSize() {
        if (dim == 0) {
            switch (genre) {
                case I32 -> {
                    return i32_size;
                }
                case I1 -> {
                    return i1_size;
                }
                case I8 -> {
                    return i8_size;
                }
                case STRUCT -> {
                    return tarStruct.getStructSize();
                }
                default -> {
                    return 0;
                }
            }
        } else return prt_size;
    }
}
