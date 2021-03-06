package pep.projet_proc.instructions.operation;

import pep.projet_proc.Parser;

/**
 * @author Loic Gardaire
 *
 * Instruction LSL avec un immediate
 */
public class LSLimm extends Operation {
    public LSLimm() {
        opType = "000";
        opCode = "00";
        immediateSize = 5;
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Operation#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+Parser.completeZero(args[2],immediateSize)+args[1]+args[0];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
