package pep.projet_proc.instructions.operation;

/**
 * @author Loic Gardaire
 *
 * Instruction ADD
 */
public class ADD extends Operation {
    public ADD() {
        super();
        opCode = "1100";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Operation#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType + opCode + args[2] + args[1] + args[0];
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
