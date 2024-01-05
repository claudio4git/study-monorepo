package linearsearch;

// Linear Search or Sequential Search
public class LinearSearch {

    public static void main(String[] args) {
        int[] values = {4, 6, 7, 9, 2, 4};

        var result1 = new LinearSearch().search(values, 2);
        System.out.printf("2 found: %s%n", result1 != -1);

        var result2 = new LinearSearch().search(values, 8);
        System.out.printf("8 found: %s%n", result2 != -1);
    }

    public int search(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return target;
            }
        }

        return -1;
    }
}
