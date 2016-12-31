package pep.projet_proc;

import pep.projet_proc.condition.Condition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 31/12/2016.
 */
public class Parser {
    public void parseFile(String fileName) throws IOException {
        List<String> flagList = new ArrayList<>();
        List<List<String>> instructionList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        for (int i = 0; scanner.hasNextLine(); i++) {
            String str = scanner.nextLine();
            str = str.replaceAll("^\\s+", "");
            if (str.contains(":")) {
                flagList.add(str);
            } else {
                List<String> instruction = new ArrayList<>();
                for (int j = 0; j < str.split(" |,").length; j++) {
                    String tmp = str.split(" |,")[j];
                    tmp = tmp.replaceAll("\\[","").replaceAll("\\]","");
                    tmp = replaceRegisterByValue(tmp);
                    tmp = replaceImmediateByValue(tmp);
                    if(isBranch(tmp)){
                        Pattern p = Pattern.compile("([A-Z])([a-z]+)");
                        Matcher m = p.matcher(tmp);
                        if (m.matches()) {
                            instruction.add(m.group(1));
                            instruction.add(Condition.valueOf(m.group(2).toUpperCase()).getCodop());
                        }
                    }else{
                        instruction.add(tmp);
                    }
                }
                instructionList.add(instruction);
            }
        }

        List<String> finalList = new ArrayList<>();
        for (int i = 0; i < instructionList.size(); i++) {
            String[] arguments = new String[instructionList.get(i).size()-1];
            List<String> tmp = instructionList.get(i).subList(1,instructionList.get(i).size());
            arguments = tmp.toArray(arguments);
            finalList.add(InstructionFactory.getTranslation(instructionList.get(i).get(0), arguments));
        }

        BufferedWriter rom = new BufferedWriter(new FileWriter("rom.txt"));
        rom.write("v2.0 raw");
        for (int i = 0; i < finalList.size(); i++) {
            rom.write(finalList.get(i)+" ");
        }
        rom.close();
    }

    public boolean isBranch(String str) {
        Pattern p = Pattern.compile("B[a-z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String completeZero(String binaryValue, int wantedLength) {
        for (int i = binaryValue.length(); i < wantedLength; i++) {
            binaryValue = "0" + binaryValue;
        }
        return binaryValue;
    }

    public String replaceRegisterByValue(String register){
        Pattern p1 = Pattern.compile("R([0-9])");
        Matcher m1 = p1.matcher(register);
        if (m1.matches()) {
            int registerRank = Integer.decode(m1.group(1));
            register = m1.replaceAll(completeZero(Integer.toBinaryString(registerRank), 3));
        }
        return register;
    }

    public String replaceImmediateByValue(String str){
        Pattern p = Pattern.compile("#([0-9]*)");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            int immediateValue = Integer.decode(m.group(1));
            str = Integer.toBinaryString(immediateValue);;
        }
        return str;
    }
}
