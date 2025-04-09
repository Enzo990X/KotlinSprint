package org.example.lesson_17

fun main() {

    val parcel1 = Parcel(1, "Москва")
    val parcel2 = Parcel(2, "Лондон")

    movePackage(parcel1)
    movePackage(parcel2)

    println(parcel1.numberOfLocations)
    println(parcel2.numberOfLocations)
}

fun movePackage(parcel: Parcel) {
    println("Зарегистрировать новое перемещение посылки № ${parcel.id}?")
    var answer = readln()

    while (answer.equals("да", ignoreCase = true)) {
        println("\nВведите новое местоположение: ")

        parcel.location = readln()

        println("\nЗарегистрировать новое перемещение посылки?")
        answer = readln()
    }
}

class Parcel(val id: Int, location: String) {

    var numberOfLocations: Int = 0

    var location: String = location
        set(value) {
            field = value
            numberOfLocations++
        }
}
