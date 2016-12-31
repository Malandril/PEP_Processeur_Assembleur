package pep.projet_proc.instructions.operation;

/**
 * Created by user on 21/12/2016.
 */
public class SUB extends Operation {
    public SUB() {
        super();
        opCode="1101";
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType+opCode+args[2]+args[1]+args[0];
        return String.format("%04X",Integer.valueOf(s,2));
    }
}
