public class FindPalindrome {
    public static void main(String[] args) {
        System.out.println("Hanah is palindrome? " + isPalindrome("Hannah"));
        System.out.println("Jhon is palindrome? " + isPalindrome("Jhon"));
    }

    private static boolean isPalindrome(String value) {
        var reversed = new StringBuilder(value).reverse().toString();
        return value.equalsIgnoreCase(reversed);
    }
}
