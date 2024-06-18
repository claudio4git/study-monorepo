package mergesorting;

import java.util.*;

import static java.lang.System.arraycopy;

/*
 * Good approach.
 *
 * Space complexity O(n)
 * Time complexity O(n log n)
 *
 * Stable: Mantêm a ordem relativa dos elementos iguais.
 * Divide and conquer.
 *
 * Divide, combine.
 */
public class GoodMergeSort {
    public static void main(String[] args) {
        int[] values = {9, 2, 5, 6, 1, 12, 45, 32, 11};
        
        System.out.println("Unsorted:" + Arrays.toString(values));
        mergeSort(values);
        System.out.println("Sorted..:" + Arrays.toString(values));
    }

    /*
     * Create and use tmp array.
     */
    private static void mergeSort(int[] values) {
        if (values.length > 2) {
            int[] tempValues = new int[values.length];
            mergeSort(values, tempValues, 0, values.length - 1);
        }
    }

    /*
     * Divide the array in two subarray.
     * Do it recursively until each element be in a subarray.
     */
    private static void mergeSort(int[] values, int[] tempValues, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;
            mergeSort(values, tempValues, leftStart, middle);
            mergeSort(values, tempValues, middle + 1, rightEnd);

            merge(values, tempValues, leftStart, rightEnd);
        }
    }

    /*
     * Combine the subarray sorting into the original array using the temp array.
     */
    private static void merge(int[] values, int[] tempValues, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        // build temp array
        while (left <= leftEnd && right <= rightEnd) {
            if (values[left] <= values[right]) {
                tempValues[index] = values[left];
                left++;
            } else {
                tempValues[index] = values[right];
                right++;
            }
            index++;
        }

        // fix temp array pending
        int leftSize = leftEnd - left + 1;
        int rightSize = rightEnd - right + 1;
        arraycopy(values, left, tempValues, index, leftSize);
        arraycopy(values, right, tempValues, index, rightSize);

        // rollback from temp to values
        int sliceSize = rightEnd - leftStart + 1;
        arraycopy(tempValues, leftStart, values, leftStart, sliceSize);
    }
}
