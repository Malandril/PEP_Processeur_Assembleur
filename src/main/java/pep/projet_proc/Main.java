package pep.projet_proc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 15/12/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(InstructionFactory.getTranslation("MOV","010","11011100"));
        List<String[]> instructionsList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextLine()) {
            String[] instruction = scanner.nextLine().split(" |,");
            instructionsList.add(instruction);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
        out.write("v2.0 raw");
        for (String[] command : instructionsList) {
            out.write(InstructionFactory.getTranslation(command[0], Arrays.copyOfRange(command, 1, command.length)));
        }
        out.close();
    }
}
