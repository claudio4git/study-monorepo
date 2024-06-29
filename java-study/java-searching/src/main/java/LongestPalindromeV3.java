/*
 * Using dynamic programming
 */
public class LongestPalindromeV3 {
    public static void main(String[] args) {
        var result = findLongestPalindrome("hanahaba");
        System.out.println(result);
    }

    public static String findLongestPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;

        // Todos os caracteres individuais são palíndromos de comprimento 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Verifica palíndromos de comprimento 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Verifica palíndromos de comprimento maior que 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }

        return str.substring(start, start + maxLength);
    }
}
