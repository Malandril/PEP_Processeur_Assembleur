package pep.projet_proc.instructions;

/**
 * @author Loic Gardaire
 * @author Thomas Canava
 *
 * Classe mère des instructions ARM
 */
public abstract class Instruction {
    public String opType ="";
    public String opCode ="";

    public String getOpType(){
        return opType;
    }

    public String getOpCode() {
        return opCode;
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     */
    public abstract String getFinalCode(String... args);

}
