package org.example.lesson_4

fun main() {

    val requiredCondition = Condition(true, true, 20, "not winter")
    val currentCondition = Condition(true, true, 20, "winter")

    val compareConditions = (requiredCondition.clearSky == currentCondition.clearSky) && (requiredCondition.tentOpen == currentCondition.tentOpen) && (requiredCondition.humidity == currentCondition.humidity) && (requiredCondition.season == currentCondition.season)

    println("Благоприятные ли условия сейчас для роста бобовых? $compareConditions")

}

class Condition(val clearSky: Boolean, val tentOpen: Boolean, val humidity: Int, val season: String)