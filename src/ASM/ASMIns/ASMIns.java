package ASM;

import ASM.ASMutility.ASMVar;

public class ASMIns {
    public InsType type;
    public ASMVar rs1;
    public ASMVar rs2;
    public ASMVar rd;
    public ASMVar imm;

    public  ASMIns(InsType type_){
        type=type_;
    }

    public enum InsType{
            add, sub, sll, sra, and, or, xor, slt,
            addi, slli, srai, andi, ori, xori, slti,
            lw, sw,
            mul, div, rem, mv, li,
            seqz, snez, beqz, j,
            call, ret
    }
}
