package org.example.lesson_3

fun main() {

    val learningDigit = 6
    val multipliersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val table = """
    $learningDigit * ${multipliersList.get(0)} = ${learningDigit * multipliersList.get(0)}
    $learningDigit * ${multipliersList.get(1)} = ${learningDigit * multipliersList.get(1)}
    $learningDigit * ${multipliersList.get(2)} = ${learningDigit * multipliersList.get(2)}
    $learningDigit * ${multipliersList.get(3)} = ${learningDigit * multipliersList.get(3)}
    $learningDigit * ${multipliersList.get(4)} = ${learningDigit * multipliersList.get(4)}
    $learningDigit * ${multipliersList.get(5)} = ${learningDigit * multipliersList.get(5)}
    $learningDigit * ${multipliersList.get(6)} = ${learningDigit * multipliersList.get(6)}
    $learningDigit * ${multipliersList.get(7)} = ${learningDigit * multipliersList.get(7)}
    $learningDigit * ${multipliersList.get(8)} = ${learningDigit * multipliersList.get(8)}
    $learningDigit * ${multipliersList.get(9)} = ${learningDigit * multipliersList.get(9)}
""".trimIndent()

    println(table)

}