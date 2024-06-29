/*
 * Using expand around
 */
public class LongestPalindromeV2 {
    public static void main(String[] args) {
        var result = findLongestPalindrome("hanahaba");
        System.out.println(result);
    }

    public static String findLongestPalindrome(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";
        int maxLengthPalindrome = 0;
        for (int i = 0; i < txt.length(); i++) {
            String palindromeEven = expandAroundCenter(txt, i, i); // even (par) for center unique
            if (palindromeEven.length() > maxLengthPalindrome) {
                maxLengthPalindrome = palindromeEven.length();
                longestPalindrome = palindromeEven;
            }

            String palindromeOdd = expandAroundCenter(txt, i, i + 1); // odd (impar) for center double
            if (palindromeOdd.length() > maxLengthPalindrome) {
                maxLengthPalindrome = palindromeOdd.length();
                longestPalindrome = palindromeOdd;
            }
        }

        return longestPalindrome;
    }

    private static String expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return txt.substring(left + 1, right);
    }
}
