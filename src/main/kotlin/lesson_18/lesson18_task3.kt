package org.example.lesson_18

fun main() {
    val fox = Fox("Алиса")
    val dog = Dog("Артемон")
    val cat = Cat("Базилио")

    val animalList: List<Animal> = listOf(fox, dog, cat)

    animalList.forEach {
        println("${it.name} - ${it.eat()}")
        println("${it.name} - ${it.sleep()}\n")
    }
}

abstract class Animal(val name: String) {
    abstract fun eat(): String
    abstract fun sleep(): String
}

class Fox(name: String) : Animal(name) {
    override fun eat(): String = "ест ягоды"
    override fun sleep(): String = "спит в норе"
}

class Dog(name: String) : Animal(name) {
    override fun eat(): String = "ест кости"
    override fun sleep(): String = "спит в конуре"
}

class Cat(name: String) : Animal(name) {
    override fun eat(): String = "ест рыбу"
    override fun sleep(): String = "спит на диване"
}