package ASM;

public class ASMVar {
    public static int base = 1 << 12;

    public ASMGenre genre;
    public regName reg;
    public int imm;
    public int offset;
    public String name;
    public int index;


    public enum regName {
        zero, ra, sp, gp, tp, t0, t1, t2, fp, s1, a0, a1, a2, a3, a4, a5, a6, a7, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, t3, t4, t5, t6
    }

    public enum ASMGenre {
        REG, IMM, GLOBAl
    }

    public boolean ifLow() {
        return imm < base && imm >= -base;
    }

    public
}
