package pep.projet_proc.instructions.dataprocessing;

/**
 * Created by user on 08/12/2016.
 */
public abstract class Instruction {
    public String opType ="";
    public String opCode ="";

    String interpret(){
        return String.format("%02X", opType);
    }

    public String getOpType(){
        return opType;
    }

    public String getOpCode() {
        return opCode;
    }

    public abstract String getFinalCode(String... args);

}
