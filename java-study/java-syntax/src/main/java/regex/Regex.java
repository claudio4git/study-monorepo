package regex;

import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Maria");
        Matcher matcher = pattern.matcher("Maria silva");

        if (matcher.find()) {
            System.out.println("Maria was found");
        } else {
            System.out.println("Didn't find Maria");
        }
    }
}
