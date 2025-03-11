package org.example.lesson_7

fun main() {
    var symbol = (0..9).random()
    var smallChar = ('a'..'z').random()
    var bigChar = ('A'..'Z').random()

    println("Введите размер пароля. Минимум 6 символов")
    var passwordSize = readln().toInt()

    while (passwordSize < 6) {
        println("Размер пароля должен быть не менее 6 символов")
        passwordSize = readln().toInt()
    }

    val range = RANGE_START..passwordSize
    var passwordChar = listOf(symbol, smallChar, bigChar).random()

    for (i in range) {
        print("$passwordChar")
        symbol = (0..9).random()
        smallChar = ('a'..'z').random()
        bigChar = ('A'..'Z').random()
        passwordChar = listOf(symbol, smallChar, bigChar).random()
    }
}

private const val RANGE_START = 0

