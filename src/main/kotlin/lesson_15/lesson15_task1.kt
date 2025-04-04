package org.example.lesson_15

abstract class Animal : Movable

abstract class Carp () : Animal() {
    override fun swim() {
        println("Карп плавает с помощью хвоста и плавников")
    }
}

abstract class Seagull () : Animal() {
    override fun fly() {
        println("Птица летает с помощью крыльев")
    }

    override fun walk() {
        println("Птица ходит с помощью ног")
    }
}

abstract class Duck () : Animal() {
    override fun swim() {
        println("Утка плавает с помощью ног")
    }

    override fun fly() {
        println("Утка летает с помощью крыльев")
    }

    override fun walk() {
        println("Утка ходит с помощью ног")
    }
}

interface Movable {
    fun swim()
    fun fly()
    fun walk()
}
