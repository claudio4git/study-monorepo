public class StringReverse {
    public static void main(String[] args) {
        System.out.println("For reserve...........: " + reverseUsingFor("maria"));
        System.out.println("StringBuilder reserve.: " + reverseUsingStringBuilder("maria"));
    }

    private static String reverseUsingFor(String value) {
        var result = new StringBuilder();

        for (int i = value.length() -1; i >= 0; i--) {
            result.append(value.charAt(i));
        }

        return result.toString();
    }

    private static String reverseUsingStringBuilder(String value) {
        return new StringBuilder(value).reverse().toString();
    }
}
