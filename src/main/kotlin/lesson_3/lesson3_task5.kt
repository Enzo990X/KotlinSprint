package org.example.lesson_3

fun main() {

    val move = "D2-D4;0"

    val getMoveNumber = move.split(";")
    val moveNumber = getMoveNumber[1].toInt()

    val getChecks = getMoveNumber[0].split("-")
    val startCheck = getChecks[0]
    val endCheck = getChecks[1]

    println(startCheck)
    println(endCheck)
    println(moveNumber)
}