package br.com.jccf.kotlinlang3

class Tests {
    fun test() {
        val names = arrayOf("claudio", "esther", "ben")

        for (name in names) {
            println(name)
        }

        println("---")

        for(i in names.indices) {
            println(names[i])
        }
    }
}

fun main() {
    Tests().test()
}
