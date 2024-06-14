package mergesorting;

import java.util.*;

/*
 *  Not good because create auxiliar int[]s.
 *
 *  Space complexity O(n log n)
 *  Time complexity O(n log n)
 */
public class InefficientMergeSort {
    public static void main(String[] args) {
        int[] values = {9, 2, 5, 6, 1, 12, 45, 32, 11};

        System.out.println("Unsorted: " + Arrays.toString(values));
        mergeSort(values, 0, values.length -1);
        System.out.println("Sorted..: " + Arrays.toString(values));
    }

    private static void mergeSort(int[] values, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(values, left, middle);
            mergeSort(values, middle + 1, right);

            merge(values, left, middle, right);
        }
    }

    private static void merge(int[] values, int left, int middle, int right) {
        int valuesLeftSize = middle - left + 1;
        int valuesRightSize = right - middle;

        int[] valuesLeft = new int[valuesLeftSize];
        int[] valuesRight = new int[valuesRightSize];

        for (int i = 0; i < valuesLeftSize; i++) {
            valuesLeft[i] = values[left + i];
        }

        for (int j = 0; j < valuesRightSize; j++) {
            valuesRight[j] = values[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        // reorder left and right values
        while (i < valuesLeftSize && j < valuesRightSize) {
            if (valuesLeft[i] <= valuesRight[j]) {
                values[k] = valuesLeft[i];
                i++;
            } else {
                values[k] = valuesRight[j];
                j++;
            }
            k++;
        }

        // rollback left values
        while (i < valuesLeftSize) {
            values[k] = valuesLeft[i];
            i++;
            k++;
        }

        // rollback right values
        while (j < valuesRightSize) {
            values[k] = valuesRight[j];
            j++;
            k++;
        }
    }
}
