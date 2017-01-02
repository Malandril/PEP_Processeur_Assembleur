package pep.projet_proc;

import pep.projet_proc.instructions.Instruction;
import pep.projet_proc.instructions.branch.B;
import pep.projet_proc.instructions.dataprocessing.*;
import pep.projet_proc.instructions.loadstore.LDR;
import pep.projet_proc.instructions.loadstore.STR;
import pep.projet_proc.instructions.operation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Loic Gardaire
 * @author Thomas Canava
 *
 * Rassemble toutes les instructions ARM et fait le lien entre l'instruction sous forme textuelle
 * et l'objet Java qui lui correspond
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
        instructionMap.put(LSL.class.getSimpleName(), new LSL());
        instructionMap.put(LSR.class.getSimpleName(), new LSR());
        instructionMap.put(MUL.class.getSimpleName(), new MUL());
        instructionMap.put(MVN.class.getSimpleName(), new MVN());
        instructionMap.put(ORR.class.getSimpleName(), new ORR());
        instructionMap.put(ROR.class.getSimpleName(), new ROR());
        instructionMap.put(RSB.class.getSimpleName(), new RSB());
        instructionMap.put(SBC.class.getSimpleName(), new SBC());
        instructionMap.put(TST.class.getSimpleName(), new TST());
        instructionMap.put(ADD.class.getSimpleName(), new ADD());
        instructionMap.put(ASRimm.class.getSimpleName(), new ASRimm());
        instructionMap.put(LSLimm.class.getSimpleName(), new LSLimm());
        instructionMap.put(LSRimm.class.getSimpleName(), new LSRimm());
        instructionMap.put(MOV.class.getSimpleName(), new MOV());
        instructionMap.put(SUB.class.getSimpleName(), new SUB());
        instructionMap.put(LDR.class.getSimpleName(), new LDR());
        instructionMap.put(STR.class.getSimpleName(), new STR());
        instructionMap.put(B.class.getSimpleName(), new B());
    }


    /**
     * Renvoie la traduction en hexadécimale de l'instruction passée en paramètre
     * @param instructionName intitulé de l'instruction
     * @param args paramètres de l'instruction
     * @return valeur hexadécimale de l'instruction
     */
    public static String getTranslation(String instructionName, String... args) {
        if (instructionName.compareTo("ASR") == 0 || instructionName.compareTo("LSL") == 0 || instructionName.compareTo("LSR") == 0){
            if(args.length == 3){
                instructionName = instructionName+"imm";
            }
        }
        return instructionMap.get(instructionName).getFinalCode(args);
    }

}
