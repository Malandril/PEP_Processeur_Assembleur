package pep.projet_proc.instructions.operation;

import pep.projet_proc.instructions.Instruction;

/**
 * @author Loic Gardaire
 *
 * Classe mère des instructions d'opération sur des registres
 */
public abstract class Operation extends Instruction {
    int immediateSize;

    public Operation() {
        opType = "000";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Instruction#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType + opCode;
        for (String arg : args) {
            s += arg;
        }
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
