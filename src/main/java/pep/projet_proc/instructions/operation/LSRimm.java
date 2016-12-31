package pep.projet_proc.instructions.operation;

import pep.projet_proc.Parser;

/**
 * Created by user on 31/12/2016.
 */
public class LSRimm extends Operation {
    public LSRimm() {
        opType = "000";
        opCode = "01";
        immediateSize = 5;
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+ Parser.completeZero(args[2],immediateSize)+args[1]+args[0];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
