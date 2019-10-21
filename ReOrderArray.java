import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReOrderArray {
    private static void reOrder(int[] array) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (int value : array) {
            if (value % 2 == 0) {
                evenList.add(value);
                continue;
            }
            oddList.add(value);
        }

        oddList.addAll(evenList);

        for (int i = 0; i < oddList.size(); i++) {
            array[i] = oddList.get(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8,0 };
        reOrder(array);
        System.out.println(Arrays.toString(array));
    }
}