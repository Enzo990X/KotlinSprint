package org.example.lesson_15

fun main() {

    println("Сколько пассажиров необходимо перевезти?")
    val passengersToMove = readln().toShort()

    println("Сколько груза необходимо перевезти?")
    val loadToMove = readln().toFloat()

    Lorry().callLorry(loadToMove)
    Taxi().callTaxi(passengersToMove)
}

class Taxi {

    private val taxiMaxNumberOfPassengers: Short = 3

    fun callTaxi(passengersToMove: Short) {

        val passengersToMoveByTaxi: Short = (passengersToMove - passengersMovedByLorry).toShort()
        println(passengersToMoveByTaxi)

        val taxiNeeded: Short = (passengersToMoveByTaxi / taxiMaxNumberOfPassengers + INCREMENT).toShort()
        println(taxiNeeded)

        val taxi = Taxi()

        for (i in 1..taxiNeeded) {
            if (i.toShort() == taxiNeeded) {
                val passengersInLastCar: Short =
                    (passengersToMoveByTaxi - (taxiNeeded - INCREMENT) * taxi.taxiMaxNumberOfPassengers).toShort()

                when (passengersInLastCar) {
                    1.toShort() -> println("Такси № $i перевезло $passengersInLastCar пассажира.")
                    2.toShort() -> println("Такси № $i перевезло $passengersInLastCar пассажиров.")
                }


            } else {

                println("Такси № $i перевезло ${taxi.taxiMaxNumberOfPassengers} пассажиров.")
            }
        }
    }
}

class Lorry {

    private val lorryMaxNumberOfPassengers: Short = 1
    private val maxLoad: Float = 2.0f

    fun callLorry(loadToMove: Float) {

        val lorryNeeded = (loadToMove / Lorry().maxLoad + INCREMENT).toInt().toShort()

        val lorry = Lorry()

        for (i in 1..lorryNeeded) {

            println("В грузовике № $i поедут пассажиры?")
            val answer = readln()
            val loadInLastLorry = loadToMove - (lorryNeeded * lorry.lorryMaxNumberOfPassengers)

            if (answer.equals("да", ignoreCase = true)) {
                passengersMovedByLorry++

                if (i.toShort() == lorryNeeded) {

                    when (loadInLastLorry) {

                        in 1.0f..1.1f -> println("Грузовик № $i перевез " +
                                "${String.format("%.2f", loadInLastLorry)} тонну груза и одного пассажира.")

                        in 1.2f..1.4f -> println("Грузовик № $i перевез " +
                                "${String.format("%.2f", loadInLastLorry)} тонны груза и одного пассажира.")

                        else -> println("Грузовик № $i перевез " +
                                "${String.format("%.2f", loadInLastLorry)} тонн груза и одного пассажира.")
                    }

                } else {
                    println("Грузовик № $i перевез ${(lorry.maxLoad).toInt()} тонны груза и одного пассажира.")
                }
            } else {

                if (i.toShort() == lorryNeeded) {
                    when (loadInLastLorry) {

                        in 1.0f..1.1f ->
                            println("Грузовик № $i перевез ${String.format("%.2f", loadInLastLorry)} тонну груза.")

                        in 1.2f..1.4f ->
                            println("Грузовик № $i перевез ${String.format("%.2f", loadInLastLorry)} тонны груза.")

                        else -> println("Грузовик № $i перевез ${String.format("%.2f", loadInLastLorry)} тонн груза.")
                    }

                } else {
                    println("Грузовик № $i перевез ${(lorry.maxLoad).toInt()} тонн груза.")
                }
            }
        }
    }
}

var passengersMovedByLorry: Short = 0

private const val INCREMENT = 1