package IR.IRUtility;

import utility.ValueType;

import java.util.List;

public class IRType {
    public String baseType;
    public int ptrRank = 0;
    boolean ifStruct;

    public IRType(ValueType valueType) {
        ptrRank = valueType.dimension;
        baseType = valueType.baseType;
        ifStruct = !valueType.isBasicType();
    }

    public IRType(ValueType valueType,int ptrRank_) {
        ptrRank = valueType.dimension;
        baseType = valueType.baseType;
        ifStruct = !valueType.isBasicType();
        ptrRank+=ptrRank_;
    }

    public IRType(IRType rhs, boolean ifPtr_) {
        this.baseType = rhs.baseType;
        this.ifStruct = rhs.ifStruct;
        this.ptrRank= ifPtr_?rhs.ptrRank+1:rhs.ptrRank;
    }

    public static IRType i32 = new IRType(ValueType.IntegerType);
    public static IRType i32_ptr = new IRType(ValueType.IntegerType);
    static {
        i32_ptr.ptrRank=1;
    }
}
