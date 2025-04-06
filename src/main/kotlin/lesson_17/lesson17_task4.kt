package org.example.lesson_17

fun main() {

    val package1 = Package(1, "Москва")
    val package2 = Package(2, "Лондон")

    println(package1.numberOfLocations)
    println(package2.numberOfLocations)
}

class Package(val id: Int, location: String) {

    var numberOfLocations: Int = 0

    var location: String = location
        set(value) {
            println("Зарегистрировать новое перемещение посылки № $id?")
            var answer = readln()

            while (answer == "Да" || answer == "да") {
                println("Введите новое местоположение: ")
                field = readln()

                numberOfLocations++

                println("\nЗарегистрировать новое перемещение посылки?")
                answer = readln()
            }
        }

    init {
        this.location = location
    }
}
