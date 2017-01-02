package pep.projet_proc.condition;

/**
 * @author Loic Gardaire
 *
 * Enumeration des différentes conditions nécessaires pour les branches et de leur valeur binaire
 */
public enum Condition {
    EQ("0000"),
    NE("0001"),
    CS("0010"),
    HS("0010"),
    CC("0011"),
    LO("0011"),
    MI("0100"),
    PL("0101"),
    VS("0110"),
    VC("0111"),
    HI("1000"),
    LS("1001"),
    GE("1010"),
    LT("1011"),
    GT("1100"),
    LE("1101"),
    AL("1110"),
    NV("1111");

    String codop;

    Condition(String codop) {
        this.codop = codop;
    }

    public String getCodop() {
        return codop;
    }
}
