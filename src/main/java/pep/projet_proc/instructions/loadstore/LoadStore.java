package pep.projet_proc.instructions.loadstore;

import pep.projet_proc.Parser;
import pep.projet_proc.instructions.Instruction;

/**
 * Created by user on 29/12/2016.
 */
public class LoadStore extends Instruction {
    int immediateSize = 5;

    public LoadStore() {
        opType = "011";
    }

    @Override
    public String getFinalCode(String[] args) {
        String s = opType + opCode;
        String immediate = "";
        String Rn = "";
        String Rt = "";
        if(args.length == 3){
            immediate = Parser.completeZero(args[2],immediateSize);
            Rn = args[1];
            Rt = args[0];
        }else{
            immediate = "00000";
            Rn = args[1];
            Rt = args[0];
        }
        s += " "+immediate+" "+Rn+" "+Rt;
        return "";
//        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
