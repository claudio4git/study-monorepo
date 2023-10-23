package algorithm;

import java.util.*;

/*
 *  Sliding window technique.
 *
 *  Example 1: abcabcbb
 *  Substring: abc
 *  Max length: 3
 *
 *  Example 2: pwwkew
 *  Substring: wke
 *  Subsequence: pwke
 *  Max length: 3
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(doByKeyValue("abcabcbb"));
        System.out.println(doByPointer("pwwkew"));
    }

    public static int doByKeyValue(String value) {
        int maxLength = 0;
        int leftPointer = 0;
        HashMap<Character, Integer> chars = new HashMap<>();

        for (int rightPointer = 0; rightPointer < value.length(); rightPointer++) {
            char currentChar = value.charAt(rightPointer);
            if (chars.containsKey(currentChar)) {
                leftPointer = Math.max(leftPointer, chars.get(currentChar) + 1);
            }
            chars.put(currentChar, rightPointer);
            int total = rightPointer - leftPointer + 1;
            maxLength = Math.max(maxLength, total);
        }

        return maxLength;
    }

    public static int doByPointer(String value) {
        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;
        HashSet<Character> chars = new HashSet<>();

        while (rightPointer < value.length()) {
            if (!chars.contains(value.charAt(rightPointer))) {
                chars.add(value.charAt(rightPointer));
                rightPointer++;
                maxLength = Math.max(chars.size(), maxLength);
            } else {
                chars.remove(value.charAt(leftPointer));
                leftPointer++;
            }
        }

        return maxLength;
    }
}
