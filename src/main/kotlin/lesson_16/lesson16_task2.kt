package org.example.lesson_16

import kotlin.math.pow

fun main() {
    val circle = Circle(5.0f)

    println(circle.perimeter())
    println(circle.area())
}

class Circle(private val radius: Float) {

    private val Pi = 3.14F

    fun perimeter(): Float {
        return MULTIPLIER * Pi * radius
    }

    fun area(): Float {
        return Pi * radius.pow(MULTIPLIER)
    }
}

private const val MULTIPLIER = 2
