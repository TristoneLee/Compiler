package ASM.ASMutility;

import IR.IRUtility.IRVar;

public class ASMImm extends ASMVar {
    public static int base = 1 << 12;
    public Integer imm;


    public ASMImm() {
        super();
        genre = ASMGenre.IMM;
    }

    public ASMImm(int imm_) {
        super();
        imm = imm_;
        genre = ASMGenre.IMM;
    }

    public String toString(){
        return imm.toString();
    }

    public boolean isLow() {
        return imm < base && imm >= -base;
    }

    public ASMImm getHigh() {
        return new ASMImm(imm >> 12);
    }

    public ASMImm getLow() {
        return new ASMImm(imm & (base - 1));
    }

}
