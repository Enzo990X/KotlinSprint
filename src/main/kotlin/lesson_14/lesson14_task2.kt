package org.example.lesson_14

fun main() {

    val ship = CruiseLiner(
        name = "Астория Гранде",
        speed = 100,
        capacity = 1000,
        passengers = 500
    )
    val cargoShip = Freighter(
        name = "Пола Макария",
        speed = 100,
        capacity = 1000,
        passengers = 500
    )
    val iceShip = IceShip(
        name = "Арктика",
        speed = 50,
        capacity = 500,
        passengers = 200
    )

    ship.printInfo()
    ship.moveOutPlatform()
    ship.moveInPlatform()

    cargoShip.printInfo()
    cargoShip.moveOutCrane()
    cargoShip.moveInCrane()

    iceShip.printInfo()
    iceShip.openGates()
    iceShip.closeGates()
}


open class CruiseLiner(
    val name: String,
    open var speed: Int,
    open var capacity: Int,
    open var passengers: Int,
    val isBreakingIce: Boolean = false,
) {

    fun printInfo() {
        println(
            "Корабль $name умеет ходить со скоростью $speed узлов " +
                    (if (isBreakingIce) ", но не во льдах." else "и пробиваться сквозь лед ") +
                    "Вмещает на борт $passengers человек и $capacity тонн груза."
        )
    }

    fun moveOutPlatform() {
        println("Корабль $name выдвинул погрузочный трап.")
    }

    fun moveInPlatform() {
        println("Корабль $name задвинул погрузочный трап.")
    }
}

class Freighter(
    name: String,
    override var speed: Int,
    override var capacity: Int,
    override var passengers: Int,
) : CruiseLiner(name, speed, capacity, passengers, isBreakingIce = false) {

    fun moveOutCrane() {
        println("Корабль $name развернул кран.")
    }

    fun moveInCrane() {
        println("Корабль $name убрал кран.")
    }
}

class IceShip(
    name: String,
    override var speed: Int,
    override var capacity: Int,
    override var passengers: Int,
) : CruiseLiner(name, speed, capacity, passengers, isBreakingIce = true) {

    fun openGates() {
        println("Корабль $name открыл кормовые ворота.")
    }

    fun closeGates() {
        println("Корабль $name закрыл кормовые ворота.")
    }
}
