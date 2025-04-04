package org.example.lesson_14

fun main() {
    val earth = Planet("Земля", true, true, true)
    val satellite1 = Satellite("Луна", false, false, earth)

    val venera = Planet("Венера", false, true, false)

    val neptun = Planet("Нептун", false, false, true)
    val satellite2 = Satellite("Триполе", false, false, neptun)
    val satellite3 = Satellite("Макемо", false, false, neptun)

    val jupiter = Planet("Юпитер", false, false, true)
    val satellite4 = Satellite("Ганимед", false, false, jupiter)
    val satellite5 = Satellite("Каллисто", false, false, jupiter)
    val satellite6 = Satellite("Европа", false, false, jupiter)

    printSatellites()
}

fun printSatellites() {
    for (planet in Planet.planets) {
        if (planet.hasSatellite) {
            when {
                planet.satellites.size == ONE -> {
                    println("У планеты ${planet.name} есть спутник ${planet.satellites.joinToString { it.name }}.")
                }

                planet.satellites.size > ONE -> {
                    val satellites = planet.satellites
                    val allButLast = planet.satellites.dropLast(ONE).joinToString { it.name }
                    println("У планеты ${planet.name} есть спутники $allButLast и ${satellites.last().name}.")
                }
            }
        } else println("У планеты ${planet.name} нет спутников.")
    }
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
    val hasSatellite: Boolean,
) : SpaceObject(name, hasAtmosphere, isLandable) {

    val satellites = mutableListOf<Satellite>()

    companion object {
        val planets = mutableListOf<Planet>()
    }

    init {
        planets.add(this)
    }
}

class Satellite(
    name: String,
    hasAtmosphere: Boolean,
    isLandable: Boolean,
    planet: Planet,
) : SpaceObject(name, hasAtmosphere, isLandable) {

    init {
        planet.satellites.add(this)
    }
}

private const val ONE = 1

