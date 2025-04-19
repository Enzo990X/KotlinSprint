package org.example.lesson_21

fun main() {

    val numbersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Сумма четных чисел: ${numbersList.evenNumbersSum()}")
}

fun List<Int>.evenNumbersSum() = this.filter { it % 2 == 0 }.sumOf { it }
