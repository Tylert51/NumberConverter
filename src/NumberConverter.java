
public class NumberConverter {

    private final String[] ALL_CHAR;
    private int b10Num;

    public NumberConverter() {
        ALL_CHAR = new String[64];

        for(int i = 0; i <= 9; i++) {
            ALL_CHAR[i] = i + "";
        }

        int ascii = 65;
        for (int i = 10; i <= 35; i++) {
            ALL_CHAR[i] = (char) ascii + "";
            ascii++;
        }

        ascii = 97;
        for (int i = 36; i <= 61; i++) {
            ALL_CHAR[i] = (char) ascii + "";
            ascii++;
        }
        ALL_CHAR[62] = "+";
        ALL_CHAR[63] = "/";
    }

    


}

