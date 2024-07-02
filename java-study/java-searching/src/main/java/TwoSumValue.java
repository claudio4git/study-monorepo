import java.util.*;

/*
 * Two Pointer Technique
 * Two direction
 */
public class TwoSumValue {
    public static void main(String[] args) {
        int[] values = {1,2,3,3,5};
        int target = 5;
        int[] results = findTwoSum(values, target);
        System.out.println(Arrays.toString(results));
    }

    private static int[] findTwoSum(int[] values, int target) {
        int left = 0;
        int right = values.length - 1;

        while (left < right) {
            int sum = values[left] + values[right];
            if (sum == target) {
                return new int[] {values[left], values[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }
}
