package org.example.lesson_14

fun main() {

    val satellite1 = Satellite("Луна", false, false)
    val satellite4 = Satellite("Ганимед", false, false)
    val satellite5 = Satellite("Каллисто", false, false)
    val satellite6 = Satellite("Европа", false, false)

    val venera = Planet("Венера", false, true, listOf())
    val earth = Planet("Земля", true, true, listOf(satellite1))
    val jupiter = Planet("Юпитер", false, false, listOf(satellite4, satellite5, satellite6))

    printSatellites(venera)
    printSatellites(earth)
    printSatellites(jupiter)
}

fun printSatellites(planet: Planet) {

    if (planet.satellites.isNotEmpty()) {
        when {
            planet.satellites.count() == ONE -> {
                println("У планеты ${planet.name} есть спутник ${planet.satellites.joinToString { it.name }}.")
            }

            planet.satellites.count() > ONE -> {
                val satellites = planet.satellites
                val allButLast = planet.satellites.dropLast(ONE).joinToString { it.name }
                println("У планеты ${planet.name} есть спутники $allButLast и ${satellites.last().name}.")
            }
        }
    } else println("У планеты ${planet.name} нет спутников.")
}

open class SpaceObject(
    val name: String,
    val hasAtmosphere: Boolean,
    val isLandable: Boolean,
)

class Planet(
    name: String,
    hasAtmosphere: Boolean,
    isLandable: Boolean,
    val satellites: List<Satellite>,
) : SpaceObject(name, hasAtmosphere, isLandable)

class Satellite(
    name: String,
    hasAtmosphere: Boolean,
    isLandable: Boolean,
) : SpaceObject(name, hasAtmosphere, isLandable)

private const val ONE = 1

