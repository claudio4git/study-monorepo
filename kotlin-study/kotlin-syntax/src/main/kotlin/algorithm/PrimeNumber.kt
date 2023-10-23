package algorithm

fun main() {
    val primeNumber = PrimeNumber()
    println("17 is prime: ${primeNumber.isPrimeV1(17)}")
    println("17 is prime: ${primeNumber.isPrimeV2(17)}")
}

class PrimeNumber {

    fun isPrimeV1(number: Int): Boolean {
        var i = 2
        while (i < number) {
            if (number % i == 0) {
                return false
            }
            i++
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
