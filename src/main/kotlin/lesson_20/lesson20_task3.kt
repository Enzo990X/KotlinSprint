package org.example.lesson_20

fun main () {

    val gamer = Gamer (true)

    val doorStatus: () -> Unit = {
        if (gamer.hasKey) {
            println("Игрок открыл дверь")
        } else {
            println("Дверь заперта")
        }
    }

    doorStatus.invoke()
}

class Gamer (val hasKey: Boolean)
