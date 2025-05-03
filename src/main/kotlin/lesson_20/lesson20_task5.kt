package org.example.lesson_20

fun main() {

    val robot = Robot()

    robot.say()
    robot.setModifier { randomPhrase: String -> randomPhrase.reversed() }
    robot.say()
}

class Robot {

    private val phrase1 = "Информация! Ещё информации!"
    private val phrase2 = "Номер 5 - живой!"
    private val phrase3 = "Привет, парни!"
    private val phrase4 = "Ньютон Кросби, не бежать, не говорить, рулить!"
    private val phrase5 = "Жизнь - это не неисправность, это другое."

    private val vocabulary = listOf(phrase1, phrase2, phrase3, phrase4, phrase5)

    private var modifier: ((String) -> String) = { randomPhrase -> randomPhrase }


    fun say() {

        val randomPhrase = vocabulary.random()
        val modifiedPhrase = modifier.invoke(randomPhrase)

        println(modifiedPhrase)
    }

    fun setModifier(modifier: (String) -> String) {

        this.modifier = modifier
    }
}
