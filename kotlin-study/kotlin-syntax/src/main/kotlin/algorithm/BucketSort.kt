package algorithm

fun main() {
    val unSortedList = arrayOf(3, 5, 6, 2)
    val sortResult = BucketSort().sort(unSortedList, 6)
    for (i in sortResult.indices) {
        for (j in 0 until sortResult[i]) {
            println(i)
        }
    }
}

class BucketSort {
    fun sort(list: Array<Int>, max: Int): Array<Int> {
        val result = Array(max + 1) { 0 }
        for (item in list) {
            result[item]++
        }
        return result
    }
}
