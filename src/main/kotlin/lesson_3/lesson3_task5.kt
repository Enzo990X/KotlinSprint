package org.example.lesson_3

fun main() {

    val move = "D2-D4;0"

    val getData = move.split("-", ";")

    val startCheck = getData[0]
    val endCheck = getData[1]
    val moveNumber = getData[2]

    println(startCheck)
    println(endCheck)
    println(moveNumber)
}