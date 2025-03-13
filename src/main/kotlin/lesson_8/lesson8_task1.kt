package org.example.lesson_8

fun main() {

    println("Введите количество просмотров в понедельник: ")
    val monday = readln().toInt()
    println("Введите количество просмотров в вторник: ")
    val tuesday = readln().toInt()
    println("Введите количество просмотров в среду: ")
    val wednesday = readln().toInt()
    println("Введите количество просмотров в четверг: ")
    val thursday = readln().toInt()
    println("Введите количество просмотров в пятницу: ")
    val friday = readln().toInt()
    println("Введите количество просмотров в субботу: ")
    val saturday = readln().toInt()
    println("Введите количество просмотров в воскресенье: ")
    val sunday = readln().toInt()

    val arrayOfViews = arrayOf(monday, tuesday, wednesday, thursday, friday, saturday, sunday)

    println("Общее количество просмотров: ${arrayOfViews.sum()}")
}