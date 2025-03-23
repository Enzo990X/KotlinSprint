package org.example.lesson_10

fun main() {

    playGame()
    askForNewGame()
}

fun rollDice() : Int {
    val rollResult = (MIN_VALUE..MAX_VALUE).random()
    Thread.sleep(SLEEP)
    println("$rollResult")
    Thread.sleep(SLEEP)
    return rollResult
}


fun playGame() {
    println("Ход компьютера: ")
    Thread.sleep(SLEEP)
    val botRoll = rollDice()
    println("Ход игрока: ")
    Thread.sleep(SLEEP)
    val playerRoll = rollDice()
    when {
        botRoll == playerRoll -> {
            println("Ничья!")
        }
        botRoll > playerRoll -> {
            println("Вы проиграли!")
        }
        else -> {
            println("Вы выиграли!")
            winsCount++
        }
    }
}

fun askForNewGame() {
    println("\nХотите сыграть ещё? (да/нет)")
    val answer = readln()
    if (answer == "да") {
        playGame()
        askForNewGame()
    }
    else endGame()
}

fun endGame() {
    when (winsCount) {
        ONE -> print("\nВы выиграли $winsCount раз!")
        in TWO..FOUR -> print("\nВы выиграли $winsCount раза!")
        else -> print("\nВы выиграли $winsCount раз!")
    }
}

private var winsCount = 0

private const val MIN_VALUE = 1
private const val MAX_VALUE = 6
private const val SLEEP: Long = 750
private const val ONE = 1
private const val TWO = 2
private const val FOUR = 4