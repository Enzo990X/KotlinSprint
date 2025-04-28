package org.example.lesson_15

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Сколько пассажиров необходимо перевезти?")
    passengersToMove = readln().toShort()

    println("Сколько груза необходимо перевезти?")
    loadToMove = readln().toInt() * TONNE

    val parkOfTaxi = MutableList(5) { Taxi(it + 1) }
    val parkOfLorry = MutableList(5) { Lorry(it + 1) }

    val lorryJob = async { manageLorries(parkOfLorry) }
    val taxiJob = async { manageTaxis(parkOfTaxi) }

    lorryJob.await()
    taxiJob.await()

    println("Все операции завершены.")
}

suspend fun manageTaxis(parkOfTaxi: List<Taxi>) = coroutineScope {
    while (passengersToMove > 0) {
        val freeTaxis = parkOfTaxi.filter { !it.isBusy }

        if (freeTaxis.isEmpty()) {
            println("Все такси заняты. Ожидание свободного...")
            while (parkOfTaxi.all { it.isBusy }) {
                delay(SLEEP)
            }
            continue
        }

        val availableTaxi = freeTaxis.random()
        availableTaxi.isBusy = true
        availableTaxi.arrive()

        if (passengersToMove > 0) {
            println("Сколько пассажиров поедет в такси №${availableTaxi.id}?")
            availableTaxi.numberOfPassengers = readln().toShort()

            while (availableTaxi.numberOfPassengers > availableTaxi.getMaxNumberOfPassengers()) {
                println("Ошибка: в такси №${availableTaxi.id} не может быть больше " +
                        "${availableTaxi.getMaxNumberOfPassengers()} пассажиров. Укажите другое количество.")
                availableTaxi.numberOfPassengers = readln().toShort()
            }

            passengersToMove = (passengersToMove - availableTaxi.numberOfPassengers).toShort()
        }

        launch {
            delay(availableTaxi.getWorkingTime())
            availableTaxi.movePassengers(availableTaxi.numberOfPassengers)
            availableTaxi.isBusy = false
        }
    }

    if (passengersToMove == 0.toShort()) {
        println("Все пассажиры успешно перевезены.")
    }
}

suspend fun manageLorries(parkOfLorry: List<Lorry>) = coroutineScope {
    while (loadToMove > 0 || passengersToMove > 0) {
        val freeLorries = parkOfLorry.filter { !it.isBusy }

        if (freeLorries.isEmpty()) {
            println("Все грузовики заняты. Ожидание свободного...")
            while (parkOfLorry.all { it.isBusy }) {
                delay(SLEEP)
            }
            continue
        }

        val availableLorry = freeLorries.random()
        availableLorry.isBusy = true
        availableLorry.arrive()

        if (passengersToMove > 0) {
            println("Грузовик №${availableLorry.id} будет перевозить пассажиров?")
            val answer = readln()

            if (answer.equals("да", ignoreCase = true)) {
                println("Сколько пассажиров поедет в грузовике №${availableLorry.id}?")
                availableLorry.numberOfPassengers = readln().toShort()

                while (availableLorry.numberOfPassengers > availableLorry.getMaxNumberOfPassengers()) {
                    println("Ошибка: в грузовике №${availableLorry.id} не может быть больше " +
                            "${availableLorry.getMaxNumberOfPassengers()} пассажиров. Укажите другое количество.")
                    availableLorry.numberOfPassengers = readln().toShort()

                    launch {
                        availableLorry.movePassengers(availableLorry.numberOfPassengers)
                    }
                }
            }
            passengersToMove = (passengersToMove - availableLorry.numberOfPassengers).toShort()
        }

        if (loadToMove > availableLorry.getMaxLoad()) {
            availableLorry.load = availableLorry.getMaxLoad()
        } else {
            availableLorry.load = loadToMove
        }

        val loadMoved = (availableLorry.load / TONNE).toFloat()
        loadToMove -= availableLorry.load

        launch {
            delay(availableLorry.getWorkingTime())
            availableLorry.moveCargo(loadMoved)
            availableLorry.isBusy = false
        }
    }

    if (loadToMove == 0) {
        println("Все грузы успешно перевезены.")
    }

    if (passengersToMove == 0.toShort()) {
        println("Все пассажиры успешно перевезены.")
    }
}

class Taxi(
    val id: Int,
    var numberOfPassengers: Short = 0,
    var isBusy: Boolean = false,
) : Movable, PassengerTransport {

    private val taxiMaxNumberOfPassengers: Short = 3
    private val workingTime: Long = 5000L

    fun getMaxNumberOfPassengers(): Short {
        return taxiMaxNumberOfPassengers
    }

    fun getWorkingTime(): Long {
        return workingTime
    }

    override fun arrive() {
        println("Такси №$id едет на заказ.")
    }

    override fun movePassengers(numberOfPassengers: Short) {
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
    var isBusy: Boolean = false,
) : Movable, PassengerTransport, CargoTransport {

    private val lorryMaxNumberOfPassengers: Short = 1
    private val maxLoad: Int = 2000
    private val workingTime: Long = 5000L

    fun getMaxNumberOfPassengers(): Short {
        return lorryMaxNumberOfPassengers
    }

    fun getMaxLoad(): Int {
        return maxLoad
    }

    fun getWorkingTime(): Long {
        return workingTime
    }

    override fun arrive() {
        println("Грузовик №$id едет на погрузку.")
    }

    override fun movePassengers(numberOfPassengers: Short) {
        when (numberOfPassengers) {
            1.toShort() -> println("Грузовик №$id привез $numberOfPassengers пассажира.")
            else -> println("Грузовик №$id привез $numberOfPassengers пассажиров.")
        }
    }

    override fun moveCargo(load: Float) {

        when (load) {

            in 1.0f..1.1f ->
                println("Грузовик №$id перевез ${String.format("%.1f", load)} тонну груза.")

            in 1.2f..1.4f ->
                println("Грузовик №$id перевез ${String.format("%.1f", load)} тонны груза.")

            2.0f ->
                println("Грузовик №$id перевез ${String.format("%.1f", load)} тонны груза.")

            else -> println("Грузовик №$id перевез ${String.format("%.1f", load)} тонн груза.")
        }
    }
}

interface Movable {
    fun arrive()
}

interface PassengerTransport {
    fun movePassengers(numberOfPassengers: Short)
}

interface CargoTransport {
    fun moveCargo(load: Float)
}

var passengersToMove: Short = 0
var loadToMove: Int = 0
private const val TONNE = 1000
private const val SLEEP = 1000L
