package org.example.lesson_6

fun main() {
    println("Введите необходимое для отсчёта время")
    var getTime = readln().toInt()

    while (getTime > 0) {

        println("Осталось секунд: ${getTime--}")
        Thread.sleep(1000)
    }

    println("Время вышло")
}
