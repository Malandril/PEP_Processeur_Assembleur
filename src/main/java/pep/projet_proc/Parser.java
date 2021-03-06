package pep.projet_proc;

import pep.projet_proc.condition.Condition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Loic Gardaire
 *         <p>
 *         Transforme le fichier d'instructions ARM en un fichier hexadécimale
 *         lisible par la ROM de l'assembleur
 */
public class Parser {
    /**
     * Ajoute les zéros nécessaires pour avoir une valeur binaire de la longueur voulue
     *
     * @param binaryValue  valeur binaire
     * @param wantedLength longueur de la valeur binaire voulue
     * @return valeur binaire avec ajout des zéros
     */
    public static String completeZero(String binaryValue, int wantedLength) {
        for (int i = binaryValue.length(); i < wantedLength; i++) {
            binaryValue = "0" + binaryValue;
        }
        return binaryValue;
    }

    /**
     * Traduit toutes les instructions du fichier en paramètre en leur valeur hexadécimale
     *
     * @param fileName nom du fichier à traduire
     * @throws IOException
     */
    public void parseFile(String fileName) throws IOException {
        List<String> lineList = new ArrayList<>();
        Map<String, Integer> flagList = new HashMap<>();
        List<List<String>> instructionList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        int i = 0;
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str = str.replaceAll("^\\s+", "");
            if (isFlag(str)) {
                flagList.put(str.replace(":", ""), i);
            } else {
                lineList.add(str);
                i++;
            }
        }
        for (String str : lineList) {
            List<String> instruction = new ArrayList<>();
            for (int j = 0; j < str.split(" |,").length; j++) {
                String tmp = str.split(" |,")[j];
                tmp = tmp.replaceAll("\\[", "").replaceAll("\\]", "");
                tmp = replaceRegisterByValue(tmp);
                tmp = replaceImmediateByValue(tmp);
                if (isBranchWithCondition(tmp)) {
                    Pattern p = Pattern.compile("([A-Z])([a-z]+)");
                    Matcher m = p.matcher(tmp);
                    if (m.matches()) {
                        instruction.add(m.group(1));
                        instruction.add(Condition.valueOf(m.group(2).toUpperCase()).getCodop());
                    }
                } else if (flagList.containsKey(tmp)) {
                    instruction.add(Integer.toBinaryString(flagList.get(tmp)));
                } else {
                    instruction.add(tmp);
                }
            }
            instructionList.add(instruction);
        }

        List<String> finalList = new ArrayList<>();
        for (int j = 0; j < instructionList.size(); j++) {
            String[] arguments = new String[instructionList.get(j).size() - 1];
            List<String> tmp = instructionList.get(j).subList(1, instructionList.get(j).size());
            arguments = tmp.toArray(arguments);
            finalList.add(InstructionFactory.getTranslation(instructionList.get(j).get(0), arguments));
        }

        BufferedWriter rom = new BufferedWriter(new FileWriter("rom.txt"));
        rom.write("v2.0 raw");
        for (int j = 0; j < finalList.size(); j++) {
            rom.write("\n" + finalList.get(j) + " ");
        }
        rom.close();
    }

    /**
     * Renvoie true si la string passée en paramètre est un flag
     *
     * @param str string à étudier
     * @return true si la string est un flag, false sinon
     */
    public boolean isFlag(String str) {
        return str.contains(":");
    }

    /**
     * Renvoie true si la string passée en paramètre est une instruction de branche conditionnelle
     *
     * @param str string à étudier
     * @return true si la string est une branche, false sinon
     */
    public boolean isBranchWithCondition(String str) {
        Pattern p = Pattern.compile("B[a-z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * Remplace un registre du banc de registres par sa valeur binaire
     *
     * @param str string à étudier
     * @return valeur binaire du registre
     */
    public String replaceRegisterByValue(String str) {
        Pattern p1 = Pattern.compile("R([0-9])");
        Matcher m1 = p1.matcher(str);
        if (m1.matches()) {
            int registerRank = Integer.decode(m1.group(1));
            str = m1.replaceAll(completeZero(Integer.toBinaryString(registerRank), 3));
        }
        return str;
    }

    /**
     * Remplace une valeur immédiate par sa valeur binaire
     *
     * @param str string à étudier
     * @return valeur binaire de l'immediate
     */
    public String replaceImmediateByValue(String str) {
        Pattern p = Pattern.compile("#([0-9]*)");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            int immediateValue = Integer.decode(m.group(1));
            str = Integer.toBinaryString(immediateValue);
        }
        return str;
    }
}
