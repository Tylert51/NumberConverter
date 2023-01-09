import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTester {
    public static void main(String[] args) {
        ArrayList<String> possibleBases = new ArrayList<String>(Arrays.asList("2", "8", "10", "16"));
        String base = "10";
        int indx = possibleBases.indexOf(base);
        possibleBases.remove(indx);

        System.out.println(possibleBases);


    }
}
