import java.util.*;

public class ArraySumZero {
    public static void main(String[] args) {
        var result1 = getArray(3);
        System.out.println("3: " + Arrays.toString(result1));

        var result2 = getArray(4);
        System.out.println("4: " + Arrays.toString(result2));

        var result3 = getArray(5);
        System.out.println("5: " + Arrays.toString(result3));

        var result4 = getArray(10);
        System.out.println("10: " + Arrays.toString(result4));
    }

    private static int[] getArray(int len) {
        var ran = new Random();
        Set<Integer> results = new HashSet<>();

        if (len % 2 != 0) {
            results.add(0);
        }

        while (results.size() < len) {
            int value = ran.ints(len * -1, len)
                    .map(item -> item == 0 ? 1 : item)
                    .findFirst()
                    .getAsInt(); // should verify if not exist in the Set
            results.add(value * -1);
            results.add(value);
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
