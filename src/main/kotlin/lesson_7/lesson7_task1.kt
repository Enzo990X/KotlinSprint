package org.example.lesson_7

fun main() {
    val symbol = (0..9).random()
    val smallChar = ('a'..'z').random()
    val bigChar = ('A'..'Z').random()

    val symbol1 = listOf(symbol, smallChar, bigChar).random()
    val symbol2 = listOf(symbol, smallChar, bigChar).random()
    val symbol3 = listOf(symbol, smallChar, bigChar).random()
    val symbol4 = listOf(symbol, smallChar, bigChar).random()
    val symbol5 = listOf(symbol, smallChar, bigChar).random()
    val symbol6 = listOf(symbol, smallChar, bigChar).random()

    println("$symbol1" + "$symbol2" + "$symbol3" + "$symbol4" + "$symbol5" + "$symbol6")

}