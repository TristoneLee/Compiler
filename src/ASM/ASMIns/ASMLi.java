package ASM.ASMIns;

public class ASMLi extends ASMIns{

    public String toString() {
        return String.format("li\t%s, %s", rd, imm);
    }
}
