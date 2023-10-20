package algorithm;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("V1: " + getReverseV1("Maria"));
        System.out.println("V2: " + getReverseV2("Maria"));
        System.out.println("V3: " + getReverseV3("Maria goes to supermarket"));
        System.out.println("V4: " + getReverseV4("Maria"));
    }

    /*
     *  StringBuffer = synchronized
     *  StringBuilder no
     */
    public static String getReverseV1(String value) {
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
    public static String getReverseV2(String value) {
        if (value.isEmpty()) {
            return value;
        }
        return getReverseV2(value.substring(1)) + value.charAt(0);
    }

    /*
     *  Recursion with phrases.
     */
    public static String getReverseV3(String value) {
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

        return getReverseV3(remainingValue) + firstWord + " ";
    }

    /*
     * Recursion using loop.
     */
    public static String getReverseV4(String value) {
        StringBuilder result = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            result.append(value.charAt(i));
        }

        return result.toString();
    }
}
