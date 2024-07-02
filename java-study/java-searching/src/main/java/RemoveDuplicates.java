import java.util.*;

/*
 * Two Pointer Technique
 * One direction
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] values = {1,1,2,2,3,4,4,5};
        int[] uniqueValues = removeDuplicated(values);
        System.out.println(Arrays.toString(uniqueValues));
    }

    private static int[] removeDuplicated(int[] values) {
        int left = 0;
        if (values.length != 0) {
            for (int right = 1; right < values.length; right++) {
                if (values[right] != values[left]) {
                    left++;
                    values[left] = values[right];
                }
            }
        }

        return Arrays.copyOf(values, left + 1);
    }
}
