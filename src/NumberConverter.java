
public class NumberConverter {

    private static final String[] ALL_CHAR = new String[64];
    private int b10Num;
    private String origNum;

    public NumberConverter(String num, int base) {
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

        origNum = num;

        if (base == 10) {
            b10Num = Integer.parseInt(num);
        } else {
            b10Num = nBaseToB10(base);
        }

    }

    public String toNBase(int baseN) {
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

        for (int i = 0; i < oNum.length; i++) {
            int num = Integer.parseInt(oNum[oNum.length - i - 1]);

            sum += (num * Math.pow(baseN, i));
        }

        return sum;
    }

    public static String[] getAllChar() {
        return ALL_CHAR;
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

