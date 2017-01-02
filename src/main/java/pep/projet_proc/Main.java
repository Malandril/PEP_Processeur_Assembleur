package pep.projet_proc;

import java.io.IOException;

/**
 * @author Loic Gardaire
 *
 * Classe principale de l'interpréteur
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.parseFile(args[0]);
    }
}
