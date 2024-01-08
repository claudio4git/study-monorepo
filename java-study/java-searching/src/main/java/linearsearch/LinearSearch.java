package linearsearch;

// Linear Search or Sequential Search
public class LinearSearch {

    public static void main(String[] args) {
        int[] values = {4, 6, 7, 9, 2, 4};

        var result = new LinearSearch().search(values, 2);
        System.out.printf("2 found: %s%n", result != -1);
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
