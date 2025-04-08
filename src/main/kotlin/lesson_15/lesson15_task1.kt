package org.example.lesson_15

abstract class Carp () : Swimable {
    override fun swim() {
        println("Карась плавает с помощью хвоста и плавников")
    }
}

abstract class Seagull () : Movable, Flyable {
    override fun walk() {
        println("Чайка ходит с помощью ног")
    }
    override fun stay() {
        println("Чайка стоит на ногах")
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

abstract class Duck () : Swimable, Movable, Flyable {
    override fun swim() {
        println("Утка плавает с помощью ног")
    }
    override fun walk() {
        println("Утка ходит с помощью ног")
    }
    override fun stay() {
        println("Утка стоит на ногах")
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

interface Swimable {
    fun swim()
}

interface Movable {
     fun walk()
     fun stay()
}

interface Flyable {
    fun takeOff()
    fun fly()
    fun land()
    fun diveIn()
}