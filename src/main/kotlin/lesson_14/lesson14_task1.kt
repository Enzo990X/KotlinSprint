package org.example.lesson_14

fun main() {

    val ship = CruiseShip(
        name = "Астория Гранде",
        speed = 100,
        capacity = 1000,
        passengers = 500
    )
    val cargoShip = CargoShip(
        name = "Пола Макария",
        speed = 100,
        capacity = 1000,
        passengers = 500
    )
    val iceShip = CargoShip.IceShip(
        name = "Арктика",
        speed = 50,
        capacity = 500,
        passengers = 200
    )

    ship.printInfo()
    cargoShip.printInfo()
    iceShip.printInfo()
}


open class CruiseShip(
    val name: String,
    open var speed: Int,
    open var capacity: Int,
    open var passengers: Int,
    val isBreakingIce: Boolean = false,
) {

    fun printInfo() {
        println("Корабль $name умеет ходить со скоростью $speed узлов " +
                (if (isBreakingIce) ", но не во льдах." else "и пробиваться сквозь лед. ") +
                "Вмещает на борт $passengers человек и $capacity тонн груза.")
    }
}

class CargoShip(
    name: String,
    override var speed: Int,
    override var capacity: Int,
    override var passengers: Int,
) : CruiseShip(name, speed, capacity, passengers, isBreakingIce = false) {

    init {
        while (capacity < CARGO_SHIP_MIN_CAPACITY) {
            println("Грузоподъемность должна быть не менее $CARGO_SHIP_MIN_CAPACITY")
            capacity = readln().toInt()
        }

        while (speed > CARGO_SHIP_SPEED_LIMIT) {
            println("Скорость должна быть не более $CARGO_SHIP_SPEED_LIMIT")
            speed = readln().toInt()
        }

        while (passengers > CARGO_SHIP_MAX_PASSENGERS) {
            println("Количество пассажиров должно быть не более $CARGO_SHIP_MAX_PASSENGERS")
            passengers = readln().toInt()
        }
    }

    class IceShip(
        name: String,
        override var speed: Int,
        override var capacity: Int,
        override var passengers: Int,
    ) : CruiseShip(name, speed, capacity, passengers, isBreakingIce = true) {

        init {
            while (capacity >= Companion.ICE_SHIP_MAX_CAPACITY) {
                println("Грузоподъемность должна быть не более ${Companion.ICE_SHIP_MAX_CAPACITY}")
                capacity = readln().toInt()
            }
            while (speed >= Companion.ICE_SHIP_SPEED_LIMIT) {
                println("Скорость должна быть не более ${Companion.ICE_SHIP_SPEED_LIMIT}")
                speed = readln().toInt()
            }
            while (passengers >= Companion.ICE_SHIP_MAX_PASSENGERS) {
                println("Количество пассажиров должно быть не более ${Companion.ICE_SHIP_MAX_PASSENGERS}")
                passengers = readln().toInt()
            }
        }

    }

    companion object {
        const val CARGO_SHIP_SPEED_LIMIT = 40
        const val ICE_SHIP_SPEED_LIMIT = 30
        const val CARGO_SHIP_MIN_CAPACITY = 5000
        const val ICE_SHIP_MAX_CAPACITY = 500
        const val CARGO_SHIP_MAX_PASSENGERS = 200
        const val ICE_SHIP_MAX_PASSENGERS = 50
    }
}

