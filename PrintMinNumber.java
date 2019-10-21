import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber{
    private static Comparator<String> comparator = (s1, s2) -> {
        String str1 = s1 + s2;
        String str2 = s2 + str1;
        return str1.compareTo(str2);
    };

    private static String PrintMinNumber(int[] numbers) {
        String[] numberStrings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numberStrings, comparator);

        System.out.println(Arrays.toString(numberStrings));
        StringBuilder sb = new StringBuilder();

        for (String numberString : numberStrings) {
            sb.append(numberString);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {3, 32, 321, 1, 21};
        System.out.println(PrintMinNumber(array));
    }
}