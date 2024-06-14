package mergesorting;

import java.util.*;

import static java.lang.System.arraycopy;

/*
 *  Good approach.
 *
 *  Space complexity O(n)
 *  Time complexity O(n log n)
 */
public class GoodMergeSort {
    public static void main(String[] args) {
        int[] values = {9, 2, 5, 6, 1, 12, 45, 32, 11};
        
        System.out.println("Unsorted:" + Arrays.toString(values));
        mergeSort(values);
        System.out.println("Sorted..:" + Arrays.toString(values));
    }

    private static void mergeSort(int[] values) {
        if (values.length < 2) {
            return; // one single value
        }

        int[] tempValues = new int[values.length];
        mergeSort(values, tempValues, 0, values.length - 1);
    }

    /*
     *  Call the method mergeSort for each value in the array.
     *  0 to 8 it calls 8 times the mergeSort.
     */
    private static void mergeSort(int[] values, int[] tempValues, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(values, tempValues, leftStart, middle);
        mergeSort(values, tempValues, middle + 1, rightEnd);

        merge(values, tempValues, leftStart, rightEnd);
    }

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
