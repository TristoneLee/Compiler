package ASM.ASMutility;

public class ASMVar {
    static int gCnt=0;
    public enum regName {
        zero, ra, sp, gp, tp, t0, t1, t2, fp, s1, a0, a1, a2, a3, a4, a5, a6, a7, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, t3, t4, t5, t6
    }

    public enum ASMGenre {
        STACK, IMM , GLOBAl
    }

    public ASMGenre genre;
    public regName reg;
    int cnt;
    public boolean ifAlloca=false;
    public boolean ifTmp;

    public ASMVar(){
        cnt=++gCnt;
    }

    public ASMVar(regName reg_){
        cnt=++gCnt;
        reg=reg_;
    }

    public String toString() {
        return reg.toString();
    }

    public boolean equals(ASMVar rhs){
        return rhs != null && rhs.cnt == this.cnt;
    }
}
