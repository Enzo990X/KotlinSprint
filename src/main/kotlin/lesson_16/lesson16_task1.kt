package org.example.lesson_16

import kotlin.random.Random

fun main() {

    val cube = Cube()
    println(cube.getSide())
}

class Cube(private var side: Short = Random.Default.nextInt(MIN_VALUE, MAX_VALUE).toShort()) {

    fun getSide() = side
}

private const val MIN_VALUE = 1
private const val MAX_VALUE = 6