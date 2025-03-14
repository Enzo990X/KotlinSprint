package org.example.lesson_4

fun main() {

    val isSkyClear = true
    val isTentOpen = true
    val currentHumidity = 20
    val currentSeason = "winter"

    val compareSky = IS_REQUIRED_SKY_CLEAR == isSkyClear
    val compareTent = IS_REQUIRED_TENT_OPEN == isTentOpen
    val compareHumidity = REQUIRED_HUMIDITY == currentHumidity
    val compareSeason = REQUIRED_SEASON != currentSeason

    val compareConditions = compareSky && compareTent && compareHumidity && compareSeason

    println("Благоприятные ли условия сейчас для роста бобовых? $compareConditions")
}

const val IS_REQUIRED_SKY_CLEAR = true
const val IS_REQUIRED_TENT_OPEN = true
const val REQUIRED_HUMIDITY = 20
const val REQUIRED_SEASON = "winter"

