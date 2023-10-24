package algorithm

/*
 * A prime number is a whole number greater than 1 whose only factors are 1 and itself.
 * The only even prime number is 2.
 *
 * Factors are 1 and itself.
 */
fun main() {
    val primeNumber = PrimeNumber()
    println("Is 23 prime number: ${primeNumber.isPrimeV1(23)}")
    println("Is 17 prime number: ${primeNumber.isPrimeV2(17)}")
}

class PrimeNumber {

    fun isPrimeV1(number: Int): Boolean {
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    fun isPrimeV2(number: Int): Boolean {
        if (number % 2 == 0) return false
        var i = 3
        while (i * i <= number) {
            if (number % i == 0) {
                return false
            }
            i++
        }
        return true
    }
}
