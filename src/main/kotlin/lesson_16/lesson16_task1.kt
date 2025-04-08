package org.example.lesson_16

fun main() {

    val cube = Cube()
    println(cube.getSide())
}

class Cube(private var side: Short = (MIN_VALUE.. MAX_VALUE).random().toShort()) {

    fun getSide() = side
}

private const val MIN_VALUE = 1
private const val MAX_VALUE = 6