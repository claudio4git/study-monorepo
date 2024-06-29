import java.util.*;

public class ArrayScanStore {
    private static final ArrayList<Integer> totals = new ArrayList<>();

    public static void main(String[] args) {
        int[] values = {1,2,3,4};
        append(values);
        System.out.println("contains 6: " + contains(6));
        System.out.println("contains 9: " + contains(9));
        System.out.println("contains 12: " + contains(12));

        int[] values2 = {1,2,3,4,5};
        append(values2);
        System.out.println("contains 6: " + contains(6));
        System.out.println("contains 9: " + contains(9));
        System.out.println("contains 12: " + contains(12));
    }

    public static void append(int[] values) {
        for (int i = 0; i < values.length - 2; i++) {
//            if (i + 2 < values.length) {
//                totals.add(values[i] + values[i+1] + values[i+2]);
//            }
            totals.add(values[i] + values[i+1] + values[i+2]);
        }
    }

    public static boolean contains(int value) {
        return totals.contains(value);
    }
}
