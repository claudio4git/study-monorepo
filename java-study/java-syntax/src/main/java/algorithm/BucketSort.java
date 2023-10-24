package algorithm;

/*
 *  Bucket Sorting Algorithm.
 *
 *  Complexity of Big O(n).
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] unSortedList = {3, 5, 6, 2};
        int[] sortResult = sort(unSortedList, 6);

        for (int i = 0; i < sortResult.length; i++) {

            // This for show when the sortResult is 1 or N increased here result[i]++
            for (int j = 0; j < sortResult[i]; j++) {
                System.out.println(i);
            }
        }
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
    public static int[] sort(int[] list, int max) {
        int[] result = new int[max + 1];

        for (int i: list) {
            result[i]++;
        }
        return result;
    }
}
