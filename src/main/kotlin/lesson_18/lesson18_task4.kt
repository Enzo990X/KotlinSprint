package org.example.lesson_18

import kotlin.math.pow

fun main() {
    val cubicParcel = CubicParcel(5.0f)
    val parallelepipedParcel = ParallelepipedParcel(5.0f, 10.0f, 7.0f)

    println("Площадь посылки равна: ${cubicParcel.area()}" + String.format(" м%c", 0x00B3) + ".")
    println("Площадь посылки равна: ${parallelepipedParcel.area()}" + String.format(" м%c", 0x00B3) + ".")
}

abstract class Parcel {
    abstract fun area(): Float
}

class CubicParcel(val side: Float) : Parcel() {
    override fun area(): Float {
        return SIX * (side.pow(TWO))
    }
}

class ParallelepipedParcel(
    val length: Float,
    val width: Float,
    val height: Float
) : Parcel() {
    override fun area(): Float {
        return TWO * (length * width + length * height + width * height)
    }
}

private const val TWO = 2
private const val SIX = 6
