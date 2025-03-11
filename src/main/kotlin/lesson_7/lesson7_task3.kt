package org.example.lesson_7

fun main(){

    println("Введите число")
    val number = readln().toInt()
    val range = RANGE_START..number step STEP

    println("Четные числа:")
    for (i in range) {
        if (i == (RANGE_START..number).last()) {
            print("$i.")
        } else {
            print("$i, ")
        }
    }
}

private const val RANGE_START = 0
private const val STEP = 2