public class FirstPalindromeV1 {
    public static void main(String[] args) {
        var result = findFirstPalindrome("abahanaha");
        System.out.println(result);
    }

    public static String findFirstPalindrome(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < txt.length(); i++) {
            int len = expandAroundCenter(txt, i, i);
            if (len > 1) {
                // "i" is to be the center of palindrome
                start = i - ((len - 1) / 2); // calculate the start using the center value
                end = i + (len / 2); // calculate the end suing the center value

                break;
            }
        }

        return txt.substring(start, end + 1);
    }

    private static int expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
