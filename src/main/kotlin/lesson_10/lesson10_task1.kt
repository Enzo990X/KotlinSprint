package org.example.lesson_10

fun main() {
    println("Ход компьютера: ")
    val botRoll = rollDice()
    Thread.sleep(SLEEP)
    println("$botRoll\n")
    Thread.sleep(SLEEP)

    println("Ход игрока: ")
    val playerRoll = rollDice()
    Thread.sleep(SLEEP)
    println("$playerRoll\n")
    Thread.sleep(SLEEP)

    if (botRoll > playerRoll) {
        println("Победила машина")
    } else if (botRoll < playerRoll) {
        println("Победило человечество")
    } else {
        println("Победила дружба")
    }
}

fun rollDice() = (MIN_VALUE..MAX_VALUE).random()

private const val MIN_VALUE = 1
private const val MAX_VALUE = 6
private const val SLEEP: Long = 1000