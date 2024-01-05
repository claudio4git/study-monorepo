package countingsort;

import java.util.*;

/*
 * V1 using 1 bucket and 2 loops.
 */
public class CountingSortV1 {
    public static void main(String[] args) {
        int[] values = {7, 6, 1, 8, 2, 9, 5, 4};
        int[] result = countingSort(values, 9);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(result));
    }

    public static int[] countingSort(int[] values, int max) {
        int l = 0;
        int[] result = new int[values.length];
        int[] bucketValues = bucket(values, max);

        // This for show when the sortResult is 1 or N increased here result[i]++
        // The index from bucketValues is the value sorted to show
        for (int i = 0; i < bucketValues.length; i++) {
            for (int j = 0; j < bucketValues[i]; j++) {
                result[l++] = i;
            }
        }

        return result;
    }

    /*
     * Result are:
     *  Key=N times found
     *  [0]=0
     *  [1]=0
     *  [2]=1
     *  [3]=1
     */
    public static int[] bucket(int[] values, int max) {
        int[] result = new int[max + 1];

        for (int i: values) {
            result[i]++;
        }

        return result;
    }
}
