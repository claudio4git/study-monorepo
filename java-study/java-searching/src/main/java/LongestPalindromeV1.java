/*
 * Using expand around and positions
 */
public class LongestPalindromeV1 {
    public static void main(String[] args) {
        var result = findLongestPalindrome("hanahaba");
        System.out.println(result);
    }

    public static String findLongestPalindrome(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < txt.length(); i++) {
            int lenEven = expandAroundCenter(txt, i, i); // even (par) for center unique
            int lenOdd = expandAroundCenter(txt, i, i + 1); // odd (impar) for center double
            int len = Math.max(lenEven, lenOdd);
            if (len > end - start) {
                // "i" is to be the center of palindrome
                start = i - ((len - 1) / 2); // calculate the start using the center value
                end = i + (len / 2); // calculate the end suing the center value
            }
        }

        return txt.substring(start, end + 1);
    }

    // left >= 0 && right < txt.length()     = inside the string
    // txt.charAt(left) == txt.charAt(right) = char is equal
    // based on txt center, expand, left-- and right++, (abaha[n]ah)
    private static int expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
