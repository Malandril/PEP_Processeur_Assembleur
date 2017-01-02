package pep.projet_proc.instructions.loadstore;

import pep.projet_proc.Parser;
import pep.projet_proc.instructions.Instruction;

/**
 * @author Loic Gardaire
 * @author Thomas Canava
 *
 * Classe mère des instructions de load et store
 */
public class LoadStore extends Instruction {
    int immediateSize = 5;

    public LoadStore() {
        opType = "011";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Instruction#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String[] args) {
        String s = opType + opCode;
        String immediate;
        if(args.length == 3){
            immediate = Parser.completeZero(args[2],immediateSize);
        }else{
            immediate = "00000";
        }
        s += immediate+args[1]+args[0];
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
