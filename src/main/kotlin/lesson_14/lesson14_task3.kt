package org.example.lesson_14

fun main() {
    val rectangle1 = Figure.Rectangle("Черный", 10.0F, 5.0F)
    val rectangle2 = Figure.Rectangle("Белый", 8.0F, 3.0F)
    val circle1 = Figure.Circle("Черный", 3.0F)
    val circle2 = Figure.Circle("Белый", 5.0F)

    val figures = listOf(rectangle1, rectangle2, circle1, circle2)


    val blackPerimeter = figures.filter { it.color == "Черный" }.sumOf { it.perimeter().toDouble() }
    println("Периметр черных фигур:" + String.format("%.2f", blackPerimeter))

    val whiteArea = figures.filter { it.color == "Белый" }.sumOf { it.area().toDouble() }
    println("Площадь белых фигур: $whiteArea")
}

abstract class Figure(val color: String) {
    abstract fun area(): Float
    abstract fun perimeter(): Float

    class Circle(color: String, val radius: Float) : Figure(color) {
        override fun area(): Float {
            return PI * radius * radius
        }

        override fun perimeter(): Float {
            return MULTIPLIER * PI * radius
        }
    }

    class Rectangle(color: String, val length: Float, val width: Float) : Figure(color) {
        override fun area(): Float {
            return length * width
        }

        override fun perimeter(): Float {
            return MULTIPLIER * (length + width)
        }
    }
}

private const val MULTIPLIER = 2
private const val PI = 3.14F