package org.example.lesson_15

fun main() {
    val instrument = Instrument(
        "Гитара", 1, listOf(
            Accessory("Струны", 4),
            Accessory("Ремень", 2), Accessory("Медиатор", 9)
        )
    )

    instrument.search()
}

interface Searchable {
    fun search()
}

abstract class Item(val name: String, val quantity: Int) : Searchable

class Instrument(name: String, quantity: Int, val accessories: List<Accessory>) : Item(name, quantity) {

    override fun search() {
        println("Выполняется аксессуаров для инструмента $name...\n")
        Thread.sleep(SLEEP)

        val accessories = accessories
        println("Для инструмента $name доступны следующие аксессуары:")
        accessories.forEach {
            println(it.name)
        }
    }
}

class Accessory(name: String, quantity: Int) : Item(name, quantity) {
    override fun search() {
        println("Выполняется поиск инструментов, для которых подходит аксессуар $name...")
    }
}

private const val SLEEP = 1000L
