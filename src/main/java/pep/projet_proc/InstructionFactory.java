package pep.projet_proc;

import pep.projet_proc.instructions.Instruction;
import pep.projet_proc.instructions.AND;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 15/12/2016.
 */
public class InstructionFactory {
        public static Map<String,Instruction> instructionMap=new HashMap<>();
        static {
            instructionMap.put(AND.class.getSimpleName(),new AND());
        }


        public static String getTranslation(String str,String... args){
            return instructionMap.get(str).getFinalCode(args);
        }

}
