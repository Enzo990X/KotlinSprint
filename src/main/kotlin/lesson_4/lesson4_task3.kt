package org.example.lesson_4

fun main() {

    val clearSky = true
    val tentOpen = true
    val humidity = 20
    val season = "winter"

    val compareClearSky = REQUIRED_CLEAR_SKY == clearSky
    val compareTentOpen = REQUIRED_TENT_OPEN == tentOpen
    val compareHumidity = REQUIRED_HUMIDITY == humidity
    val compareSeason = REQUIRED_SEASON != season

    val compareConditions = compareClearSky && compareTentOpen && compareHumidity && compareSeason

   /*
    val requiredCondition = Condition(true, true, 20, "winter")
    val currentCondition = Condition(true, true, 20, "winter")

    val compareClearSky = requiredCondition.clearSky == currentCondition.clearSky
    val compareTentOpen = requiredCondition.tentOpen == currentCondition.tentOpen
    val compareHumidity = requiredCondition.humidity == currentCondition.humidity
    val compareSeason = requiredCondition.season != currentCondition.season
    val compareConditions = compareClearSky && compareTentOpen && compareHumidity && compareSeason
*/
    println("Благоприятные ли условия сейчас для роста бобовых? $compareConditions")

}

class Condition(val clearSky: Boolean, val tentOpen: Boolean, val humidity: Int, val season: String)

const val REQUIRED_CLEAR_SKY = true
const val REQUIRED_TENT_OPEN = true
const val REQUIRED_HUMIDITY = 20
const val REQUIRED_SEASON = "winter"

