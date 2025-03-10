package org.example.lesson_6

fun main() {
    println("Введите необходимое для отсчёта время:")
    val getTime = readln().toInt()

    Thread.sleep(getTime * MILLISECONDS)

    println("Прошло $getTime секунд")
}

const val MILLISECONDS: Long = 1000