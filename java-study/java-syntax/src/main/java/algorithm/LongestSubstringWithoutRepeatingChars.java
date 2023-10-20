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
        System.out.println(getLongestSubstringV1("abcabcbb"));
        System.out.println(getLongestSubstringV2("pwwkew"));
    }

    public static int getLongestSubstringV1(String value) {
        int maxLength = 0;
        int aPointer = 0;
        HashMap<Character, Integer> chars = new HashMap<>();

        for (int bPointer = 0; bPointer < value.length(); bPointer++) {
            char currentChar = value.charAt(bPointer);
            if (chars.containsKey(currentChar)) {
                aPointer = Math.max(aPointer, chars.get(currentChar) + 1);
            }
            chars.put(currentChar, bPointer);
            maxLength = Math.max(maxLength, bPointer - aPointer + 1);
        }

        return maxLength;
    }

    public static int getLongestSubstringV2(String value) {
        int aPointer = 0;
        int bPointer = 0;
        int maxLength = 0;
        HashSet<Character> chars = new HashSet<>();

        while (bPointer < value.length()) {
            if (!chars.contains(value.charAt(bPointer))) {
                chars.add(value.charAt(bPointer));
                bPointer++;
                maxLength = Math.max(chars.size(), maxLength);
            } else {
                chars.remove(value.charAt(aPointer));
                aPointer++;
            }
        }

        return maxLength;
    }
}
