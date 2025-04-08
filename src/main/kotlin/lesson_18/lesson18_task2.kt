package org.example.lesson_18

fun main() {
    val d4 = D4()
    val d6 = D6()
    val d8 = D8()

    val diceList = listOf(d4, d6, d8)

    diceList.forEach { it.rollDice(it.numberOfSides) }
}

open class Dice(val numberOfSides: Int) {

    fun rollDice(numberOfSides: Int) {

        val rollResult = (MIN_VALUE..numberOfSides).random()
        println("Результат броска: $rollResult.")
    }
}

class D4 : Dice(MAX_VALUE_FOUR_SIDES)
class D6 : Dice(MAX_VALUE_SIX_SIDES)
class D8 : Dice(MAX_VALUE_EIGHT_SIDES)

private const val MIN_VALUE = 1
private const val MAX_VALUE_FOUR_SIDES = 4
private const val MAX_VALUE_SIX_SIDES = 6
private const val MAX_VALUE_EIGHT_SIDES = 8