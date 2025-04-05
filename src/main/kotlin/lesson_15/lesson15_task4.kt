package org.example.lesson_15

fun main() {
    val instrument = Instrument(
        "Гитара", 1, listOf(
            Accessory("Струны", 4),
            Accessory("Ремень", 2), Accessory("Медиатор", 9)
        )
    )

    instrument.searchForAccessories(instrument)
}

interface Searchable {
    fun searchForAccessories(instrument: Instrument) {
        println("Выполняется аксессуаров для инструмента ${instrument.name}...\n")
        Thread.sleep(SLEEP)

        val accessories = instrument.accessories
        println("Для инструмента ${instrument.name} доступны следующие аксессуары:")
        accessories.forEach {
            println(it.name)
        }
    }
}

abstract class Item(val name: String, val quantity: Int) : Searchable

class Instrument(name: String, quantity: Int, val accessories: List<Accessory>) : Item(name, quantity)

class Accessory(name: String, quantity: Int) : Item(name, quantity)

private const val SLEEP = 1000L
