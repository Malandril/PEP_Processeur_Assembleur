package pep.projet_proc.instructions.operation;

/**
 * @author Loic Gardaire
 *
 * Instruction SUB
 */
public class SUB extends Operation {
    public SUB() {
        super();
        opCode="1101";
    }

    /**
     * Méthode retournant la valeur hexadecimale de l'instruction
     * @param args arguments de l'instruction
     * @return valeur hexadecimale de l'instruction
     * @see Operation#getFinalCode(String...)
     */
    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+args[2]+args[1]+args[0];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
