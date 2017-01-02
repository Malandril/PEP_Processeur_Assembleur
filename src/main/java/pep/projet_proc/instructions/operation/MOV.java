package pep.projet_proc.instructions.operation;

import pep.projet_proc.Parser;

/**
 * @author Loic Gardaire
 *
 * Instruction MOV
 */
public class MOV extends Operation {
    public MOV() {
        opType = "001";
        opCode = "00";
        immediateSize = 8;
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Operation#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+args[0]+ Parser.completeZero(args[1],immediateSize);
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
