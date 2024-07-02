/*
 * Two Pointer Technique
 * Two direction
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String text1 = "hanah";
        System.out.println(isPalindrome(text1));

        String text2 = "maria";
        System.out.println(isPalindrome(text2));
    }

    private static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() -1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
