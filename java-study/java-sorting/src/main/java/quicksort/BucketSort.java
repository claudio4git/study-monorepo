package quicksort;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] values = {7, 6, 1, 8, 2, 9, 5, 4};
        int[] result = bucketSort(values);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(result));
    }

    public static int[] bucketSort(int[] values) {
        int l = 0;
        int[] result = new int[8];
        int[] bucketValues = bucket(values, 9);

        for (int i = 0; i < bucketValues.length; i++) {
            // This for show when the sortResult is 1 or N increased here result[i]++
            for (int j = 0; j < bucketValues[i]; j++) {
                result[l] = i;
                l++;
            }
        }

        return result;
    }

    /*
     * Result are:
     *  [0]=0
     *  [1]=0
     *  [2]=1
     *  [3]=1
     *  [4]=0
     *  [5]=1
     *  [6]=1
     */
    public static int[] bucket(int[] list, int max) {
        int[] result = new int[max + 1];

        for (int i: list) {
            result[i]++;
        }

        return result;
    }
}
