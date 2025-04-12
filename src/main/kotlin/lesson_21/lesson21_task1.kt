package org.example.lesson_21

fun main() {

    val string = "hello"
    string.vowelCount()
}

fun String.vowelCount() {
    val vowels = this.count { it in VOWELS }
    when (vowels) {
        ZERO -> println("В строке нет гласных букв")
        ONE -> println("В строке $vowels гласная буква")
        in TWO..FOUR -> println("В строке $vowels гласных буквы")
        else -> println("В строке $vowels гласных букв")
    }
}

private const val VOWELS = "aeiouyAEIOUY"
private const val ZERO = 0
private const val ONE = 1
private const val TWO = 2
private const val FOUR = 4
