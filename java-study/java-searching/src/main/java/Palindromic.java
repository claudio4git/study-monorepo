public class Palindromic {
    public static void main(String[] args) {
        var result = getLongestPalindrome("abhanah");
        System.out.println(result);
    }

    public static String getLongestPalindrome(String txt) {
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < txt.length(); i++) {
            int lenEven = expandAroundCenter(txt, i, i); // par
            int lenOdd = expandAroundCenter(txt, i, i + 1); // impar
            int len = Math.max(lenEven, lenOdd);
            if (len > end - start) {
                // "i" is the center of palindrome
                start = i - (len - 1) / 2; // calculate the start using the center value
                end = i + len / 2; // calculate the end suing the center value
            }
        }

        return txt.substring(start, end + 1);
    }

    // left >= 0 && right < txt.length()     = inside the string
    // txt.charAt(left) == txt.charAt(right) = char is equal
    // based on txt center, expand, left-- and right++, (ha[n]ah)
    private static int expandAroundCenter(String txt, int left, int right) {
        while (left >= 0 && right < txt.length() && txt.charAt(left) == txt.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
