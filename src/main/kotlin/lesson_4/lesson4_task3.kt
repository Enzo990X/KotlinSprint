package org.example.lesson_4

fun main() {

    val isSkyClear = true
    val isTentOpen = true
    val currentHumidity = 20
    val currentSeason = "winter"

    val compareSky = REQUIRED_SKY_IS_CLEAR == isSkyClear
    val compareTent = REQUIRED_TENT_IS_OPEN == isTentOpen
    val compareHumidity = REQUIRED_HUMIDITY == currentHumidity
    val compareSeason = REQUIRED_SEASON != currentSeason

    val compareConditions = compareSky && compareTent && compareHumidity && compareSeason

    println("Благоприятные ли условия сейчас для роста бобовых? $compareConditions")
}

const val REQUIRED_SKY_IS_CLEAR = true
const val REQUIRED_TENT_IS_OPEN = true
const val REQUIRED_HUMIDITY = 20
const val REQUIRED_SEASON = "winter"

