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

        String longest = "";
        int max = 0;
        for (int i = 0; i < txt.length(); i++) {
            String palindromeEven = expandAroundCenter(txt, i, i); // even (par) for center unique
            if (palindromeEven.length() > max) {
                max = palindromeEven.length();
                longest = palindromeEven;
            }

            String palindromeOdd = expandAroundCenter(txt, i, i + 1); // odd (impar) for center double
            if (palindromeOdd.length() > max) {
                max = palindromeOdd.length();
                longest = palindromeOdd;
            }
        }

        return longest;
    }

    private static String expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return txt.substring(left + 1, right);
    }
}
