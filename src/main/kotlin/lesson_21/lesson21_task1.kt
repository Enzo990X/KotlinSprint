package org.example.lesson_21

fun main() {

    val string = "hello"
    val counted = string.vowelCount()
    when (counted) {
        ZERO -> println("В строке нет гласных букв")
        ONE -> println("В строке $counted гласная буква")
        in TWO..FOUR -> println("В строке $counted гласных буквы")
        else -> println("В строке $counted гласных букв")
    }
}

fun String.vowelCount(): Int {
    val vowelsCount = this.count { it in VOWELS }
    return vowelsCount
}

private const val VOWELS = "aeiouyAEIOUY"
private const val ZERO = 0
private const val ONE = 1
private const val TWO = 2
private const val FOUR = 4
