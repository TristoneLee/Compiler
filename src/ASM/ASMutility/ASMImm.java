package ASM.ASMutility;

import IR.IRUtility.IRVar;

public class ASMImm extends ASMVar {
    public static int base = 1 << 12;
    public int imm;


    public ASMImm() {
        super();
        genre = ASMGenre.IMM;
    }

    public ASMImm(int imm_) {
        super();
        imm = imm_;
        genre = ASMGenre.IMM;
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
