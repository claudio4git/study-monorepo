package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] values = {1, 2, 4, 5, 6, 7, 9};

        var result = new BinarySearch().search(values, 2);
        System.out.printf("2 found: %s%n", result != -1);
    }

    public int search(int[] values, int target) {
        int begin = 0;
        int finish = values.length -1;

        while (begin <= finish) {
            int middle = (begin + finish) / 2;

            if (values[middle] == target) {
                return target;
            } else if (values[middle] < target) {
                begin = middle + 1;
            } else {
                finish = middle - 1;
            }
        }

        return -1;
    }
}
