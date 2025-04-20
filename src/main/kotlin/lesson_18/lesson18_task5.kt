package org.example.lesson_18

fun main() {
    val screen = Screen()
    screen.draw(1, 2, 3)
    screen.draw(1, 2, 5, 4)
    screen.draw(1, 2, 3f)
}


class Screen {

    fun draw(x: Int, y: Int, size: Int) {
        println("Нарисован квадрат от точки ($x, $y) размером $size")
    }

    fun draw(x: Int, y: Int, length: Int, width: Int) {
        println("Нарисован прямоугольник от точки ($x, $y) размером $length на $width")
    }

    fun draw(x: Int, y: Int, diameter: Float) {
        println("Нарисован круг с центром ($x, $y) и диаметром $diameter")
    }
}