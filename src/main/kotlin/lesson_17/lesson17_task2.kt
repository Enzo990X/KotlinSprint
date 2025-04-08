package org.example.lesson_17

fun main() {

    val ship = Ship("Аврора", 10.0f, "Санкт-Петербург")
    ship.name = "Варяг"
}

class Ship(
    name: String,
    val averageSpeed: Float,
    val homePort: String,
) {

    var name: String = name
        set(value) {
            if (field != value) {
                println("Ошибка. Имя корабля не может быть изменено.")
            }
            field = this.name
        }
}
