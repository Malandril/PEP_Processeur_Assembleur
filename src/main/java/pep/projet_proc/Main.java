package pep.projet_proc;

import java.io.IOException;

/**
 * Created by user on 15/12/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.parseFile(args[0]);
    }
}
