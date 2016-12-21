package pep.projet_proc.instructions.operation;

import pep.projet_proc.instructions.Instruction;

/**
 * Created by user on 15/12/2016.
 */
public abstract class Operation extends Instruction {
    public Operation() {
        opType = "000";
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType + opCode;
        for (String arg : args) {
            s += arg;
        }
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
