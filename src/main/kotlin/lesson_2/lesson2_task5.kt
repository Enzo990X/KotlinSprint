package org.example.lesson_2

import kotlin.math.pow

fun main() {

    val amount = 70000
    val annualInterestRate = 16.7
    val compoundsPerYear = 1
    val years = 20

    val result = amount * (SUMMAND + annualInterestRate / TOTAL_PERCENTAGE).pow(years / compoundsPerYear)

    println(String.format("%.3f", result))
}


private const val TOTAL_PERCENTAGE = 100
const val SUMMAND = 1
