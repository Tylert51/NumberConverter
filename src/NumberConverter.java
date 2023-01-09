
public class NumberConverter {

    private final String[] ALL_CHAR;
    private int b10Num;
    private String origNum;

    public NumberConverter(int num, int base) {
        ALL_CHAR = new String[64];

        for(int i = 0; i <= 9; i++) {
            ALL_CHAR[i] = i + "";
        }

        int asciiDiff = 55;
        for (int i = 10; i <= 61; i++) {
            if(i >= 36) {
                asciiDiff = 61;
            }

            ALL_CHAR[i] = (char) (i + asciiDiff) + "";
        }
        ALL_CHAR[62] = "+";
        ALL_CHAR[63] = "/";

        origNum = num + "";

        if (base == 10) {
            b10Num = num;
        } else {
            b10Num = nBaseToB10(base);
        }

    }

    public String b10ToNBase(int baseN) {
        String conversion = "";
        int num = b10Num;

        while (num != 0) {
            conversion = ALL_CHAR[num % baseN] + conversion;
            num /= baseN;
        }

        return conversion;
    }

    public int nBaseToB10(int baseN) {
        String[] oNum = new String[origNum.length()];
        int sum = 0;

        for (int i = 0; i < origNum.length(); i++) {
            oNum[i] = origNum.charAt(i) + "";
            oNum[i] = findInd(oNum[i]) + "";
        }

        for (int i = oNum.length - 1; i >= 0; i--) {
            int num = Integer.parseInt(oNum[i]);

            sum += (num * Math.pow(baseN, i));
        }

        return sum;
    }

    public int getB10Num() {
        return b10Num;
    }

    private int findInd(String symbol) {
        for (int i = 0; i < ALL_CHAR.length; i++) {
            if (symbol.equals(ALL_CHAR[i])) {
                return i;
            }
        }

        return -1;
    }
}

