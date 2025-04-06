package org.example.lesson_17

fun main() {
    val quiz = Quiz("Ответ на главный вопрос Вселенной?", "42")

    if (quiz.answer == quiz.correctAnswer) {
        println("[меланхолический вздох...] Вы дали правильный ответ, хотя это не приносит мне радости...")
    } else println("[вздох...] Вы дали неправильный ответ.\nХотя мне всё равно...")
}

class Quiz(question: String, val correctAnswer: String) {

    var question: String = ""
        get() = field

    var answer: String = ""
        get() = field
        set(value) {
            println("Ваш ответ:")
            field = readln()
        }

    init {
        this.question = question
        println(question)
        this.answer = answer
    }
}
