package pep.projet_proc;

import pep.projet_proc.instructions.Instruction;
import pep.projet_proc.instructions.dataprocessing.*;
import pep.projet_proc.instructions.operation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 15/12/2016.
 */
public class InstructionFactory {
    public static Map<String, Instruction> instructionMap = new HashMap<>();

    static {
        instructionMap.put(ADC.class.getSimpleName(), new ADC());
        instructionMap.put(AND.class.getSimpleName(), new AND());
        instructionMap.put(ASR.class.getSimpleName(), new ASR());
        instructionMap.put(BIC.class.getSimpleName(), new BIC());
        instructionMap.put(CMN.class.getSimpleName(), new CMN());
        instructionMap.put(CMP.class.getSimpleName(), new CMP());
        instructionMap.put(EOR.class.getSimpleName(), new EOR());
        instructionMap.put(MUL.class.getSimpleName(), new MUL());
        instructionMap.put(MVN.class.getSimpleName(), new MVN());
        instructionMap.put(ORR.class.getSimpleName(), new ORR());
        instructionMap.put(ROR.class.getSimpleName(), new ROR());
        instructionMap.put(RSB.class.getSimpleName(), new RSB());
        instructionMap.put(SBC.class.getSimpleName(), new SBC());
        instructionMap.put(TST.class.getSimpleName(), new TST());

        instructionMap.put(ADD.class.getSimpleName(), new ADD());
        instructionMap.put(MOV.class.getSimpleName(), new MOV());
        instructionMap.put(SUB.class.getSimpleName(), new SUB());
    }


    public static String getTranslation(String str, String... args) {
        return instructionMap.get(str).getFinalCode(args);
    }

}
