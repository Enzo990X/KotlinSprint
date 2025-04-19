package org.example.lesson_19

fun main() {
    val spaceship = Spaceship()

    spaceship.takeOff()
    spaceship.land()
    spaceship.shoot()
}

class Spaceship {
    fun takeOff() {
        println("Корабль взлетает")
    }

    fun land() {
        println("Корабль приземляется")
        // TODO Дописать логику приземления
    }

    fun shoot() {
        TODO()
    }
}