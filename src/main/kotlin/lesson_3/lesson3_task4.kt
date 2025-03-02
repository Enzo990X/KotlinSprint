package org.example.lesson_3

fun main() {
/*
    var startPosition = "E2"
    var endPosition = "E4"
    var moveNumber = 1

    var move = "$startPosition-$endPosition; $moveNumber"
    println(move)

    startPosition = "D2"
    endPosition = "D4"
    moveNumber = 2

    move = "$startPosition-$endPosition; $moveNumber"
    println(move)
*/
    val move1 = Move("E2", "E4", 1)
    val move2 = Move("D2", "D3", 2)

    println(move1)
    println(move2)
}

class Move(private val startPosition: String, private val endPosition: String, private val moveNumber: Int)
{
    override fun toString(): String {
        return "$startPosition-$endPosition; $moveNumber"
    }
}
