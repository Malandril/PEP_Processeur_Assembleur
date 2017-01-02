package pep.projet_proc.instructions.dataprocessing;

import pep.projet_proc.instructions.Instruction;

/**
 * @author Loic Gardaire
 * @author Thomas Canava
 *
 * Classe mère des instructions de data processing
 */
public abstract class DataProcessing extends Instruction {
    public DataProcessing() {
        opType="010000";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Instruction#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+args[1]+args[0];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
