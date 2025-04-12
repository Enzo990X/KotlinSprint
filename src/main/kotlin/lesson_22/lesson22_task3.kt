package org.example.lesson_22

fun main() {

    val person = Person("Антон", 30, 180)
    val (name, age, height) = person

    println("$name, $age лет, $height см.")
}

data class Person(val name: String, val age: Int, val height: Int)
