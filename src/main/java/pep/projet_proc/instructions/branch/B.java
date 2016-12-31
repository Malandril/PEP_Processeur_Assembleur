package pep.projet_proc.instructions.branch;

import pep.projet_proc.Parser;
import pep.projet_proc.instructions.Instruction;

/**
 * Created by user on 29/12/2016.
 */
public class B extends Instruction {
    int immmediateSize = 8;

    public B() {
        opType = "11";
        opCode = "01";
    }

    @Override
    public String getFinalCode(String... args) {

        String s="";
        if (args.length == 2) {
            args[1] = "00000000";
            s = opType + opCode + args[0] + Parser.completeZero(args[1], immmediateSize);
        } else{
            args[0] = "00000000";
            s = opType + opCode + "0000" + Parser.completeZero(args[0], immmediateSize);
        }
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
