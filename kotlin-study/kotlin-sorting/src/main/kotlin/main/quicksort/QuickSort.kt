package main.quicksort

class QuickSort {
    fun sort(values: IntArray, begin: Int, end: Int) {
        if (begin < end) {
            val pivotIndex = partition(values, begin, end)
            sort(values, begin, pivotIndex - 1)
            sort(values, pivotIndex + 1, end)
        }
    }

    private fun partition(values: IntArray, begin: Int, end: Int): Int {
        val pivot = values[begin]
        var i = begin // current position to swap

        for (j in (begin + 1)..end) {
            if (values[j] <= pivot) {
                i++
                swap(values, j, i)
            }
        }

        swap(values, begin, i) // move pivot to meddle

        return i
    }

    private fun swap(values: IntArray, from: Int, to: Int) {
        val tmpFrom = values[from]
        values[from] = values[to]
        values[to] = tmpFrom
    }
}

fun main() {
    val values = intArrayOf(7, 6, 1, 8, 2, 9, 5, 4)
    println(values.contentToString())
    QuickSort().sort(values, 0, values.size - 1)
    println(values.contentToString())
}
