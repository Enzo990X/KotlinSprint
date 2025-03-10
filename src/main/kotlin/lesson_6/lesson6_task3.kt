package org.example.lesson_6

fun main() {
    println("Введите необходимое для отсчёта время")
    val getTime = readln().toInt()
    var i = getTime

    while (i <= getTime) {

        println("Осталось секунд: ${i--}")
        Thread.sleep(1000)
        if (i == 0) break
    }

    println("Время вышло")
}