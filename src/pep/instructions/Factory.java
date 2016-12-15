package pep.instructions;

import pep.instructions.Exception.InvalidInstructionException;
import pep.instructions.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 08/12/2016.
 */
public class Factory {
    public static Map<String,Class<Instruction>> instructionMap=new HashMap<>();
    static {

    }
    public static Instruction createInstruction(String str) throws IllegalAccessException, InstantiationException, InvalidInstructionException {
        Class<Instruction> instructionClass = instructionMap.get(str);
        if(instructionClass!=null){
            return instructionClass.newInstance();
        }
        else {
            throw new InvalidInstructionException();
        }

    }
}
