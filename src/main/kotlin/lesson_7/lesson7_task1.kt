package org.example.lesson_7

fun main() {
    var symbol = (0..9).random()
    var smallChar = ('a'..'z').random()
    var bigChar = ('A'..'Z').random()

    val range = RANGE_START..RANGE_END
    var passwordChar = listOf(symbol, smallChar, bigChar).random()

    print("Ваш пароль: ")
    for (i in range) {
        print("$passwordChar")
        symbol = (0..9).random()
        smallChar = ('a'..'z').random()
        bigChar = ('A'..'Z').random()
        passwordChar = listOf(symbol, smallChar, bigChar).random()
    }
}

private const val RANGE_START = 0
private const val RANGE_END = 6