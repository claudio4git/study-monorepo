package algorithm

fun main() {
    val algo = LongestSubstringWithoutRepeatingChars()
    println(algo.doByKeyValue("abcabcbb"))
    println(algo.doByPointer("pwwkew"))
}

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
class LongestSubstringWithoutRepeatingChars {

    fun doByKeyValue(value: String) : Int {
        var maxLength = 0
        var leftPointer = 0
        val chars = hashMapOf<Char, Int>()

        for (rightPointer in value.indices) {
            val currentChar = value[rightPointer]
            if (chars.containsKey(currentChar)) {
                leftPointer = leftPointer.coerceAtLeast(chars[currentChar]!! + 1) // max
            }
            chars[currentChar] = rightPointer
            val total = rightPointer - leftPointer + 1
            maxLength = maxLength.coerceAtLeast(total) // max
        }

        return maxLength
    }

    fun doByPointer(value: String) : Int {
        var leftPoint = 0
        var rightPoint = 0
        var maxLength = 0
        val chars = hashSetOf<Char>()

        while (rightPoint < value.length) {
            if (!chars.contains(value[rightPoint])) {
                chars.add(value[rightPoint])
                rightPoint++
                maxLength = chars.size.coerceAtLeast(maxLength) // max
            } else {
                chars.remove(value[leftPoint])
                leftPoint++
            }
        }

        return maxLength
    }
}
