package org.example.lesson_5

fun main() {

    println("Введите Ваш вес в килограммах")
    val weight = readln().toFloat()

    println("Введите Ваш рост в сантиметрах")
    val height = readln().toFloat()
    val convertHeight = height / CM_IN_M

    val index = weight / (convertHeight * convertHeight)

    when {
        index < 18.5 -> println("Недостаточная масса тела")
        (index >= 18.5) && (index < 25) -> println("Нормальная масса тела")
        (index >= 25) && (index < 30) -> println("Избыточная масса тела")
        else -> println("Ожирение")
    }

    println("Индекс массы тела: ${String.format("%.2f", index)}")
}

const val CM_IN_M = 100