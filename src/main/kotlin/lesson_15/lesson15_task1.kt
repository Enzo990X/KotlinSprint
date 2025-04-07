package org.example.lesson_15

abstract class Animal : Movable, Flyable

abstract class Carp () : Animal() {
    override fun swim() {
        println("Карп плавает с помощью хвоста и плавников")
    }
}

abstract class Seagull () : Animal() {
    override fun walk() {
        println("Чайка ходит с помощью ног")
    }
    override fun takeOff() {
        println("Чайка взлетает с помощью крыльев")
    }
    override fun fly() {
        println("Чайка летает с помощью крыльев")
    }
    override fun land() {
        println("Чайка приземляется с помощью крыльев")
    }
    override fun diveIn() {
        println("Чайка пикирует")
    }
}

abstract class Duck () : Animal() {
    override fun swim() {
        println("Утка плавает с помощью ног")
    }
    override fun walk() {
        println("Утка ходит с помощью ног")
    }
    override fun takeOff() {
        println("Утка взлетает с помощью крыльев")
    }
    override fun fly() {
        println("Утка летает с помощью крыльев")
    }
    override fun land() {
        println("Утка приземляется с помощью крыльев")
    }
    override fun diveIn() {
        println("Утка пикирует")
    }
}

interface Movable {
    fun swim()
    fun walk()
}

interface Flyable {
    fun takeOff()
    fun fly()
    fun land()
    fun diveIn()
}