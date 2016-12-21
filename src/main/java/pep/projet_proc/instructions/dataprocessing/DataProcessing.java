package pep.projet_proc.instructions.dataprocessing;

import pep.projet_proc.instructions.Instruction;

/**
 * Created by user on 08/12/2016.
 */
public abstract class DataProcessing extends Instruction {
    public DataProcessing() {
        opType="010000";
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType +opCode+args[0]+args[1];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
