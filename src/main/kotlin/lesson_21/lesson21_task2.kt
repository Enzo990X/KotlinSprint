package org.example.lesson_21

fun main() {

    val numbersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    numbersList.evenNumbersSum()
}

fun List<Int>.evenNumbersSum() = println("Сумма четных чисел: ${this.filter { it % 2 == 0 }.sumOf { it }}")
