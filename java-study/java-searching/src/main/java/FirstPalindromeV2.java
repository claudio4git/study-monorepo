public class FirstPalindromeV2 {
    public static void main(String[] args) {
        var result = findFirstPalindrome("abahanaha");
        System.out.println(result);
    }

    public static String findFirstPalindrome(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        for (int i = 0; i < txt.length(); i++) {
            String palindrome = expandAroundCenter(txt, i, i);
            if (palindrome.length() > 1) {
                return palindrome;
            }
        }

        return "";
    }

    private static String expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return txt.substring(left + 1, right);
    }
}
