package org.example.lesson_15

fun main() {

    println("Сколько пассажиров необходимо перевезти?")
    var passengersToMove = readInput().toShort()

    println("Сколько тонн груза необходимо перевезти?")
    var loadToMove = readInput() * TONNE

    val parkOfTaxi = MutableList(5) { Taxi(it + 1) }
    val parkOfLorry = MutableList(5) { Lorry(it + 1) }

    manageLorries(parkOfLorry, passengersToMove, loadToMove)

    println(passengersToMove)
    manageTaxis(parkOfTaxi, passengersToMove)

    println("Грузов для перевозки нет.")
    println("Пассажиров для перевозки нет.")
}

fun readInput(): Int {
    while (true) {
        val answer = readln()
        if (answer.isEmpty()) {
            println("Ошибка: пустая строка. Пожалуйста, введите число.")
            continue
        }

        try {
            return answer.toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: введите действительное число.")
        }
    }
}

fun manageTaxis(parkOfTaxi: List<Taxi>, passengersToMove: Short) {
    while (passengersToMove > 0) {

        val availableTaxi = parkOfTaxi.random()
        availableTaxi.arrive()
        askAboutPassengers(availableTaxi, passengersToMove)
        availableTaxi.getPassengers(availableTaxi.numberOfPassengers)
        availableTaxi.carryPassengers(availableTaxi.numberOfPassengers)
    }
}

fun manageLorries(parkOfLorry: List<Lorry>, passengersToMove: Short, loadToMove: Int) {

    var loadInWork = loadToMove

    while (loadInWork > 0) {

        val availableLorry = parkOfLorry.random()
        availableLorry.arrive()

        if (passengersToMove > 0) {

            askAboutPassengers(availableLorry, passengersToMove)
        }

        println("Сколько килограмм загрузить в грузовик №${availableLorry.id}?")
        availableLorry.load = readInput()

        while (availableLorry.load > availableLorry.getMaxLoad()) {
            println(
                "Ошибка: грузовик №${availableLorry.load} не может перевезти " +
                        "${availableLorry.getMaxLoad()} килограмм. Укажите другое количество."
            )
            availableLorry.load = readInput()
        }

        while (availableLorry.load > loadToMove) {
            println("Ошибка: осталось груза - $loadToMove. Укажите другое количество.")
            availableLorry.load = readInput()
        }

        loadInWork -= availableLorry.load
        val loadMoved = availableLorry.load.toFloat() / TONNE

        if (availableLorry.numberOfPassengers > 0) {
            availableLorry.carryPassengers(availableLorry.numberOfPassengers)
        }
        availableLorry.moveCargo(loadMoved)
    }
}

fun askAboutPassengers(availableLorry: Lorry, passengersToMove: Short): Short {

    var passengersInWork = passengersToMove

    println("Грузовик №${availableLorry.id} будет перевозить пассажиров? (да/нет)")
    var answer = readln()

    while (!answer.equals("да", ignoreCase = true) && !answer.equals("нет", ignoreCase = true)) {
        println("Ошибка. Повторите ввод.")
        answer = readln()
    }

    when {
        answer.equals("да", ignoreCase = true) -> {
            println("Сколько пассажиров поедет в грузовике №${availableLorry.id}?")
            availableLorry.numberOfPassengers = readInput().toShort()

            while (availableLorry.numberOfPassengers > availableLorry.getMaxNumberOfPassengers()) {
                println(
                    "Ошибка: в грузовике №${availableLorry.id} не может быть больше " +
                            "${availableLorry.getMaxNumberOfPassengers()} пассажиров. Укажите другое количество."
                )
                availableLorry.numberOfPassengers = readInput().toShort()
                }
            availableLorry.getPassengers(availableLorry.numberOfPassengers)
        }

        answer.equals("нет", ignoreCase = true) -> return passengersToMove
    }

    passengersInWork = (passengersInWork - availableLorry.numberOfPassengers).toShort()
    return passengersInWork
}

fun askAboutPassengers(availableTaxi: Taxi, passengersToMove: Short): Short {

    var passengersInWork = passengersToMove

    println("Сколько пассажиров поедет в такси №${availableTaxi.id}?")
    availableTaxi.numberOfPassengers = readInput().toShort()

    while (availableTaxi.numberOfPassengers > availableTaxi.getMaxNumberOfPassengers()) {
        println(
            "Ошибка: в такси №${availableTaxi.id} не может быть больше " +
                    "${availableTaxi.getMaxNumberOfPassengers()} пассажиров. Укажите другое количество."
        )
        availableTaxi.numberOfPassengers = readInput().toShort()
    }

    while (availableTaxi.numberOfPassengers > passengersInWork) {
        println("Ошибка: осталось пассажиров - $passengersInWork. Укажите другое количество.")
        availableTaxi.numberOfPassengers = readInput().toShort()
    }

    passengersInWork = (passengersInWork - availableTaxi.numberOfPassengers).toShort()
    return passengersInWork
}


class Taxi(
    val id: Int,
    var numberOfPassengers: Short = 0,
) : Movable, PassengerTransport {

    private val taxiMaxNumberOfPassengers: Short = 3

    fun getMaxNumberOfPassengers(): Short {
        return taxiMaxNumberOfPassengers
    }

    override fun arrive() {
        println("Такси №$id приехало на заказ.")
    }

    override fun getPassengers(numberOfPassengers: Short) {
        when (numberOfPassengers) {
            1.toShort() -> println("Такси №$id сел $numberOfPassengers пассажир.")
            else -> println("В такси №$id село $numberOfPassengers пассажира.")
        }
    }

    override fun carryPassengers(numberOfPassengers: Short) {
        when (numberOfPassengers) {
            1.toShort() -> println("Такси №$id привезло $numberOfPassengers пассажира.")
            else -> println("Такси №$id привезло $numberOfPassengers пассажиров.")
        }
    }
}

class Lorry(
    val id: Int,
    var numberOfPassengers: Short = 0,
    var load: Int = 0,
) : Movable, PassengerTransport, CargoTransport {

    private val lorryMaxNumberOfPassengers: Short = 1
    private val maxLoad: Int = 2000

    fun getMaxNumberOfPassengers(): Short {
        return lorryMaxNumberOfPassengers
    }

    fun getMaxLoad(): Int {
        return maxLoad
    }

    override fun arrive() {
        println("Грузовик №$id приехал на погрузку.")
    }

    override fun getPassengers(numberOfPassengers: Short) {
        when (numberOfPassengers) {
            1.toShort() -> println("В грузовик №$id сел $numberOfPassengers пассажир.")
            else -> println("В грузовик  №$id село $numberOfPassengers пассажиров.")
        }
    }

    override fun carryPassengers(numberOfPassengers: Short) {
        when (numberOfPassengers) {
            1.toShort() -> println("Грузовик №$id привез $numberOfPassengers пассажира.")
            else -> println("Грузовик №$id привез $numberOfPassengers пассажиров.")
        }
    }

    override fun moveCargo(load: Float) {

        when (load) {

            in 1.0f..1.1f ->
                println("Грузовик №$id перевез ${String.format("%.2f", load)} тонну груза.")

            in 1.2f..1.4f ->
                println("Грузовик №$id перевез ${String.format("%.2f", load)} тонны груза.")

            2.0f ->
                println("Грузовик №$id перевез ${String.format("%.2f", load)} тонны груза.")

            else -> println("Грузовик №$id перевез ${String.format("%.2f", load)} тонн груза.")
        }
    }
}

interface Movable {
    fun arrive()
}

interface PassengerTransport {

    fun getPassengers(numberOfPassengers: Short)

    fun carryPassengers(numberOfPassengers: Short)
}

interface CargoTransport {

    fun moveCargo(load: Float)
}

private const val TONNE = 1000
