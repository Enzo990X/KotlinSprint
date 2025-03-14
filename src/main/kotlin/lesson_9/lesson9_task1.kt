package org.example.lesson_9

fun main() {

    val listOfIngredients = mutableListOf<String>()
    println("Введите количество ингредиентов в списке: ")
    val listSize = readln().toInt()

    for (i in START_INDEX until listSize) {
        println("Введите ${i + INCREMENT} ингредиент: ")
        val ingredient = readln()
        listOfIngredients.add(ingredient)
    }

    println("В рецепте есть следующие ингредиенты:")
    for (ingredient in listOfIngredients) {
        println(ingredient)
    }
}

private const val INCREMENT = 1
private const val START_INDEX = 0