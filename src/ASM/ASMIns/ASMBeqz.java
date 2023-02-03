package ASM.ASMIns;

import ASM.ASMBlock;
import ASM.ASMutility.ASMVar;

public class ASMBeqz extends ASMIns {
    ASMBlock dest;

    public ASMBeqz(ASMVar.regName rs1_, ASMBlock dest_) {
        rs1 = rs1_;
        dest = dest_;
    }

    public String toString() {
        return String.format("beqz\t%s, %s", rs1, dest.id());
    }

}
