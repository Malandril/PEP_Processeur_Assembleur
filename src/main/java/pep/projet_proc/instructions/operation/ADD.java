package pep.projet_proc.instructions.operation;

/**
 * Created by user on 15/12/2016.
 */
public class ADD extends Operation {
    public ADD() {
        super();
        opCode = "1100";
    }

    @Override
    public String getFinalCode(String... args) {
        String s = opType + opCode + args[2] + args[1] + args[0];
        return String.format("%04X", Integer.valueOf(s, 2));
    }
}
