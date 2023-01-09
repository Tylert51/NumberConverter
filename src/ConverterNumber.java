import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class ConverterNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 ,16): ");
        ArrayList<String> possibleBases = new ArrayList<String>(Arrays.asList("2", "8", "10", "16"));
        ArrayList<String> basesNames = new ArrayList<String>(Arrays.asList("Binary", "Octal", "Decimal", "Hexadecimal"));

        String base = s.nextLine();

        while (!possibleBases.contains(base)) {
            System.out.print("Not a valid base. Re-enter a valid base(2, 8, 10, or 16): ");
            base = s.nextLine();
        }
        int indOfBase = possibleBases.indexOf(base);

        possibleBases.remove(base);
        basesNames.remove(indOfBase);

        int numBase = Integer.parseInt(base);
        System.out.print("Enter your number: ");
        String number = s.nextLine();

        while (!checkInput(number, numBase)) {
            System.out.print("Not a valid number. Re-enter a valid number with your base: ");
            number = s.nextLine();
        }

        NumberConverter num = new NumberConverter(number, numBase);

        for (int i = 0; i < possibleBases.size(); i++) {
            numBase = Integer.parseInt(possibleBases.get(i));

            System.out.println(basesNames.get(i) + " number: " + num.toNBase(numBase));
        }

    }

    private static boolean checkInput(String input, int base) {
        String[] allChar = NumberConverter.getAllChar();


        for (int i = 0; i < input.length(); i++) {
            String letter = input.charAt(i) + "";
            int indOfInp = findInd(letter, allChar);

            if (indOfInp > base - 1 || indOfInp == -1) {
                return false;
            }
        }
        return true;
    }

    private static int findInd(String symbol, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (symbol.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }
}

