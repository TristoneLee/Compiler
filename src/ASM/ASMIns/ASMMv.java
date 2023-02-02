package ASM.ASMIns;

public class ASMMv extends ASMIns {

    public String toString() {
        return String.format("mv\t%s, %s", rd, rs1);
    }
}
