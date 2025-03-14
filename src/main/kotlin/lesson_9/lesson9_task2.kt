package org.example.lesson_9

fun main() {

    val listOfIngredients = mutableListOf<String>()
    listOfIngredients.add("помидор")
    listOfIngredients.add("перец")
    listOfIngredients.add("картофель")
    print("В рецепте есть следующие ингредиенты: " + listOfIngredients.joinToString() + ".\n")

    println("Желаете добавить еще?")
    val answer = readln()
    if (answer != "да") return

    println("Какой ингредиент вы хотите добавить?")
    val newIngredient = readln()
    listOfIngredients.add(newIngredient)

    println("Теперь в рецепте есть следующие ингредиенты: " + listOfIngredients.joinToString() + ".")
}