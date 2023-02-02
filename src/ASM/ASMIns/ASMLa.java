package ASM.ASMIns;

public class ASMLa extends ASMIns {
    public ASMLa(){}

    public String toString() {
        return String.format("la\t%s, %s", rd, imm);
    }
}
