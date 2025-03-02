package org.example.lesson_4

fun main() {

    val oddDayTraining = Exercises(true, false, false, true)
    val evenDayTraining = Exercises(false, true, true, false)

    val day = 5
    val trainingPlan = if (day % 2 == 0) evenDayTraining else oddDayTraining

    println("""
    Упражнения для рук:    ${trainingPlan.armExcerise} 
    Упражнения для ног:    ${trainingPlan.legExcerise}
    Упражнения для спины:  ${trainingPlan.backExcerise}
    Упражнения для пресса: ${trainingPlan.absExcerise}              
    """.trimIndent())
}

class Exercises(val armExcerise: Boolean, val legExcerise: Boolean, val backExcerise: Boolean, val absExcerise: Boolean)