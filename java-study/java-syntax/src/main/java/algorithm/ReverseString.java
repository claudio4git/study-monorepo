package algorithm;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("V1: " + doByStringBuffer("Maria"));
        System.out.println("V2: " + doByRecursion("Maria"));
        System.out.println("V3: " + doFromPhraseByRecursion("Maria goes to supermarket"));
        System.out.println("V4: " + doByFor("Maria"));
    }

    /*
     *  StringBuffer = synchronized
     *  StringBuilder no
     */
    public static String doByStringBuffer(String value) {
        return new StringBuffer(value).reverse().toString();
    }

    /*
     *  Using recursion.
     *
     *  Input: Maria
     *  1: aria + M
     *  2: ria + a
     *  3: ia + r
     *  4: a + i
     *  5: empty + a (last and first result)
     *  Output: airaM
     */
    public static String doByRecursion(String value) {
        if (value.isEmpty()) {
            return value;
        }
        return doByRecursion(value.substring(1)) + value.charAt(0);
    }

    /*
     *  Recursion with phrases.
     */
    public static String doFromPhraseByRecursion(String value) {
        if (value.isEmpty()) {
            return value;
        }

        String[] values = value.split(" ", 2);
        String firstWord = values[0];
        String remainingValue;
        if (values.length == 2) {
            remainingValue = values[1];
        } else {
            remainingValue = "";
        }

        return doFromPhraseByRecursion(remainingValue) + firstWord + " ";
    }

    /*
     * Recursion using loop.
     */
    public static String doByFor(String value) {
        StringBuilder result = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            result.append(value.charAt(i));
        }

        return result.toString();
    }
}
