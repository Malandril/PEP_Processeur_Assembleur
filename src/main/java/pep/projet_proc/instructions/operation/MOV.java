package pep.projet_proc.instructions.operation;

import pep.projet_proc.Parser;

/**
 * Created by user on 21/12/2016.
 */
public class MOV extends Operation {
    public MOV() {
        opType = "001";
        opCode = "00";
        immediateSize = 8;
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+args[0]+ Parser.completeZero(args[1],immediateSize);
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
