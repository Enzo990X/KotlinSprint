package org.example.lesson_10

fun main() {

    println("Введите размер пароля. Минимум 6 символов")
    var passwordSize = readln().toInt()

    while (passwordSize < 6) {
        println("Размер пароля должен быть не менее 6 символов")
        passwordSize = readln().toInt()
    }

    println("Ваш пароль: ${generatePassword(passwordSize)}")
}

fun generatePassword(passwordSize: Int): String {
    val numberRange = FIRST_NUMBER..LAST_NUMBER
    var number: Int
    val symbolRange = (33..47).map { it.toChar() }.toCharArray() +
            (58..64).map { it.toChar() }.toCharArray() + (91..96).map { it.toChar() }.toCharArray() +
            (123..126).map { it.toChar() }.toCharArray()
    var symbol: Char

    val range = RANGE_START..passwordSize
    var password = ""

    for (i in range step STEP) {
        symbol = symbolRange.random()
        number = numberRange.random()
        password = password + number + symbol
    }

    return password
}

private const val FIRST_NUMBER = 0
private const val LAST_NUMBER = 9
private const val RANGE_START = 0
private const val STEP = 3