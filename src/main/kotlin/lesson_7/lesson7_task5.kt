package org.example.lesson_7

fun main() {
    val symbolRange = FIRST_SYMBOL..LAST_SYMBOL
    var symbol = symbolRange.random()
    val smallCharRange = FIRST_SMALL_CHAR..LAST_SMALL_CHAR
    var smallChar = smallCharRange.random()
    val bigCharRange = FIRST_BIG_CHAR..LAST_BIG_CHAR
    var bigChar = bigCharRange.random()

    println("Введите размер пароля. Минимум 6 символов")
    var passwordSize = readln().toInt()

    while (passwordSize < 6) {
        println("Размер пароля должен быть не менее 6 символов")
        passwordSize = readln().toInt()
    }

    val passwordChar1 = symbol
    val passwordChar2 = smallChar
    val passwordChar3 = bigChar

    val range = RANGE_START..passwordSize
    var passwordChar = listOf(symbol, smallChar, bigChar).random()
    var password = listOf(passwordChar1, passwordChar2, passwordChar3, passwordChar)

    for (i in range) {
        symbol = symbolRange.random()
        smallChar = smallCharRange.random()
        bigChar = bigCharRange.random()
        passwordChar = listOf(symbol, smallChar, bigChar).random()
        password = password + passwordChar
    }

    val shuffledPassword = password.shuffled().joinToString("")
    println(shuffledPassword)
}

private const val RANGE_START = 3
private const val FIRST_SYMBOL = 0
private const val LAST_SYMBOL = 9
private const val FIRST_SMALL_CHAR = 'a'
private const val LAST_SMALL_CHAR = 'z'
private const val FIRST_BIG_CHAR = 'A'
private const val LAST_BIG_CHAR = 'Z'

