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
    int immediateSize = 8;

    public LoadStore() {
        opType = "1001";
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
        String immediate = Parser.completeZero(args[1],immediateSize);
        s += args[0]+immediate;
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
