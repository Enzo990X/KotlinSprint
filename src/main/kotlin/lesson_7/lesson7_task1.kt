package org.example.lesson_7

fun main() {
    val symbolRange = FIRST_SYMBOL..LAST_SYMBOL
    var symbol: Int
    val charRange = FIRST_CHAR..LAST_CHAR
    var char: Char

    val range = RANGE_START..RANGE_END
    var password = ""

    for (i in range step STEP) {
        symbol = symbolRange.random()
        char = charRange.random()
        password = password + symbol + char
    }

    println(password)
}

private const val FIRST_SYMBOL = 0
private const val LAST_SYMBOL = 9
private const val FIRST_CHAR = 'a'
private const val LAST_CHAR = 'z'
private const val RANGE_START = 0
private const val RANGE_END = 6
private const val STEP = 3