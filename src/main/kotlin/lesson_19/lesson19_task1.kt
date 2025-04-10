package org.example.lesson_19

fun main() {

    for (i in Fish.entries) {
        println(i.getName())
    }
}

enum class Fish {
    GUPPY { override fun getName() = "Гуппи" },
    ANGELFISH { override fun getName() = "Скалярия" },
    GOLDFISH { override fun getName() = "Золотая рыбка" },
    SIAMESE_FIGHTING_FISH { override fun getName() = "Петушок" };

    abstract fun getName(): String
}

