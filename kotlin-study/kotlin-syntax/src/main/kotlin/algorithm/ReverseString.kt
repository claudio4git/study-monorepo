package algorithm

fun main() {
    val algo = ReverseString()

    println(algo.doByNative("Maria"))
    println(algo.doByFor("Maria"))
    println(algo.doByRecursion("Maria"))
    println(algo.doFromPhraseByRecursion("Maria goes to supermarket"))
}

class ReverseString {

    fun doByNative(value: String) =
        value.reversed()

    fun doByFor(value: String): String {
        var result = ""
        for (i in value.length - 1 downTo 0) {
            result += value[i]
        }
        return result
    }

    fun doByRecursion(value: String) : String {
        if (value.isEmpty()) {
            return ""
        }

        return doByRecursion(value.substring(1)) + value[0]
    }

    fun doFromPhraseByRecursion(phrase: String) : String {
        if (phrase.isEmpty()) {
            return ""
        }

        val values = phrase.split(" ", limit = 2)
        val firstValue = values[0]
        val remainingValue = if (values.size == 2) {
            values[1]
        } else {
            ""
        }

        return doFromPhraseByRecursion(remainingValue) + firstValue + " "
    }
}

