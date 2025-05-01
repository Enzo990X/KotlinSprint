package org.example.lesson_15

fun main() {

    println("Укажите количество пассажиров и грузов:")
    val order = Order(readInput().toShort(), readInput() * TONNE)

    val parkOfTaxi = MutableList(5) { Taxi(it + 1) }
    val parkOfLorry = MutableList(5) { Lorry(it + 1) }

    manageLorries(parkOfLorry, order)
    manageTaxis(parkOfTaxi, order)

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

fun manageTaxis(parkOfTaxi: List<Taxi>, order: Order) {
    while (order.passengers > 0) {

        val availableTaxi = parkOfTaxi.random()
        availableTaxi.arrive()
        askAboutPassengers(availableTaxi, order)
        availableTaxi.getPassengers(availableTaxi.numberOfPassengers)
        availableTaxi.carryPassengers(availableTaxi.numberOfPassengers)
    }
}

fun manageLorries(parkOfLorry: List<Lorry>, order: Order) {

    while (order.load > 0) {

        val availableLorry = parkOfLorry.random()
        availableLorry.arrive()

        if (order.passengers > 0) askAboutPassengers(availableLorry, order)

        println("Сколько килограмм загрузить в грузовик №${availableLorry.id}?")
        availableLorry.load = readInput()

        while (availableLorry.load > availableLorry.getMaxLoad()) {
            println(
                "Ошибка: грузовик №${availableLorry.id} не может перевезти " +
                        "${availableLorry.getMaxLoad()} килограмм. Укажите другое количество."
            )
            availableLorry.load = readInput()
        }

        while (availableLorry.load > order.load) {
            println("Ошибка: осталось груза - ${order.load}. Укажите другое количество.")
            availableLorry.load = readInput()
        }

        order.load -= availableLorry.load
        val loadMoved = availableLorry.load.toFloat() / TONNE

        if (availableLorry.numberOfPassengers > 0) {
            availableLorry.carryPassengers(availableLorry.numberOfPassengers)
        }
        availableLorry.moveCargo(loadMoved)
    }
}

fun askAboutPassengers(availableLorry: Lorry, order: Order) {

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

        answer.equals("нет", ignoreCase = true) -> return
    }

    order.passengers = (order.passengers - availableLorry.numberOfPassengers).toShort()
}

fun askAboutPassengers(availableTaxi: Taxi, order: Order) {

    println("Сколько пассажиров поедет в такси №${availableTaxi.id}?")
    availableTaxi.numberOfPassengers = readInput().toShort()

    while (availableTaxi.numberOfPassengers > availableTaxi.getMaxNumberOfPassengers()) {
        println(
            "Ошибка: в такси №${availableTaxi.id} не может быть больше " +
                    "${availableTaxi.getMaxNumberOfPassengers()} пассажиров. Укажите другое количество."
        )
        availableTaxi.numberOfPassengers = readInput().toShort()
    }

    while (availableTaxi.numberOfPassengers > order.passengers) {
        println("Ошибка: осталось пассажиров - ${order.passengers}. Укажите другое количество.")
        availableTaxi.numberOfPassengers = readInput().toShort()
    }

    order.passengers = (order.passengers - availableTaxi.numberOfPassengers).toShort()
}

class Order(
    var passengers: Short,
    var load: Int,
)

class Taxi(
    val id: Int,
    var numberOfPassengers: Short = 0,
    private val taxiMaxNumberOfPassengers: Short = 3,
) : Movable, PassengerTransport {

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
    private val lorryMaxNumberOfPassengers: Short = 1,
    private val maxLoad: Int = 2000,
) : Movable, PassengerTransport, CargoTransport {

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
