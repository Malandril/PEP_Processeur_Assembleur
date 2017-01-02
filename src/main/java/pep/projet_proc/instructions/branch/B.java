package pep.projet_proc.instructions.branch;

import pep.projet_proc.Parser;
import pep.projet_proc.condition.Condition;
import pep.projet_proc.instructions.Instruction;

/**
 * @author Loic Gardaire
 *
 * Instruction de branche conditionnelle B
 */
public class B extends Instruction {
    int immmediateSize = 8;

    public B() {
        opType = "11";
        opCode = "01";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Instruction#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s;
        if (args.length == 2) {
            s = opType + opCode + args[0] + Parser.completeZero(args[1], immmediateSize);
        } else{
            s = opType + opCode + Condition.valueOf("AL").getCodop() + Parser.completeZero(args[0], immmediateSize);
        }
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
