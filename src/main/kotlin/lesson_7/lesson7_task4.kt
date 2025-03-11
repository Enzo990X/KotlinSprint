package org.example.lesson_7

fun main() {
    println("Введите необходимое для отсчёта время:")
    val getTime = readln().toInt()

    for (i in 1..getTime) {
        if (i == (1..getTime).last()) {
            println("Время вышло")
        } else {
            println("Осталось секунд: ${getTime - i}")
            Thread.sleep(MILLISECONDS)
        }
    }
}

private const val MILLISECONDS: Long = 1000