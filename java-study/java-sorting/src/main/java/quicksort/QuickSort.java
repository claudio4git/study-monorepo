package quicksort;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] values = {7, 6, 1, 8, 2, 9, 5, 4};
        System.out.println(Arrays.toString(values));
        new QuickSort().sort(values, 0, values.length -1);
        System.out.println(Arrays.toString(values));
    }

    /*
        Partition method split in two sides of values.
        One side with values smaller than the pivot and
        Another side with values greater than the pivot.

        Finally, call recursively quickSort with two sides.
     */
    private void sort(int[] values, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(values, begin, end);
            sort(values, begin, partitionIndex - 1);
            sort(values, partitionIndex + 1, end);
        }
    }

    /*
        Pivot is the key of performance of this pattern.
        Choosing the "right" pivot make this code faster.
        You can use: first, average, last or random value for pivot.
     */
    private int partition(int[] values, int begin, int end) {
        int pivot = values[end]; // pivot value

        swap(values, begin, end); // when using last or random value of pivot

        int i = begin; // current position to swap

        for (int j = begin + 1; j <= end; j++) {
            if (values[j] <= pivot) {
                i++;
                swap(values, i, j);
            }
        }

        swap(values, begin, i); // move pivot to meddle

        return i;
    }

    private void swap(int[] values, int from, int to) {
        int tmpFrom = values[from];
        values[from] = values[to];
        values[to] = tmpFrom;
    }
}
