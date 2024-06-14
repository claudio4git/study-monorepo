package quicksort;

import java.util.*;

/*
 * Using last value as pivot.
 *
 * Best time O(n log n)
 * Worse time O(n^2)
 *
 * Best space O(log n)
 * Worse space O(n)
 */
public class BasicPivotQuickSort {
    public static void main(String[] args) {
        int[] values = {9, 2, 5, 6, 1, 12, 45, 32, 11};

        System.out.println("Unsorted: " + Arrays.toString(values));
        quickSort(values, 0, values.length -1);
        System.out.println("Sorted..: " + Arrays.toString(values));
    }

    /*
     * Partition method split in two sides of values.
     * One side with values smaller than the pivot and
     * Another side with values greater than the pivot.
     *
     * Finally, call recursively quickSort with two sides.
     */
    private static void quickSort(int[] values, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(values, begin, end);

            quickSort(values, begin, partitionIndex - 1);
            quickSort(values, partitionIndex + 1, end);
        }
    }

    /*
     * Pivot is the key of performance of this pattern.
     * Choosing the "right" pivot make this code faster.
     * Choosing the "random" pivot minimize the possibility of worse space.
     *
     * You can use: first, average, last or random value for pivot.
     */
    private static int partition(int[] values, int begin, int end) {
        int pivot = values[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (values[j] < pivot) {
                i++;
                swap(values, i, j);
            }
        }

        swap(values, end, i + 1);

        return i + 1;
    }

    private static void swap(int[] values, int from, int to) {
        int tmpFrom = values[from];
        values[from] = values[to];
        values[to] = tmpFrom;
    }
}
