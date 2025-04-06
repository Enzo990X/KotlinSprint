package org.example.lesson_17

fun main() {

    val ship = Ship("Аврора", 10.0f, "Санкт-Петербург")
}

class Ship(
    name: String,
    val averageSpeed: Float,
    val homePort: String,
) {

    var name: String = name
        set(value) {
            println("Введите имя корабля: ")
            field = readln()
            if (field != value) {
                println("\nОшибка. Имя корабля не может быть изменено.")
            } else println("\nОбъект создан.")
        }

    init {
        this.name = name
    }
}
