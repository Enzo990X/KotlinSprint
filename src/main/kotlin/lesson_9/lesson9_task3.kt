package org.example.lesson_9

fun main() {

    val quantityOfIngridients = mapOf("яйцо" to 2, "молоко" to 50, "сливочное масло" to 15)

    println("Сколько порций Вы хотите приготовить?")
    val numberOfPortions = readln().toInt()

    val calculate = quantityOfIngridients.mapValues { it.value * numberOfPortions }

    when (numberOfPortions) {
        ONE -> print("На одну порцию Вам понадобится: ")
        in TWO..FOUR -> print("На $numberOfPortions порции Вам понадобится: ")
        else -> print("На $numberOfPortions порций Вам понадобится: ")
    }
    println("яйцо - ${calculate["яйцо"]} шт., молоко - ${calculate["молоко"]} мл, " +
            "сливочное масло - ${calculate["сливочное масло"]} гр.")
}

private const val ONE = 1
private const val TWO = 2
private const val FOUR = 4