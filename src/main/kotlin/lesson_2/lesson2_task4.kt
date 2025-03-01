package org.example.lesson_2

fun main() {

    val buffGainPercentage = 0.2f
    val crystalOreExtractedQuantity = 7
    val ironOreExtractedQuantity = 11

    val crystalOreBonusExtractedQuantity = (crystalOreExtractedQuantity * buffGainPercentage).toInt()
    val ironOreBonusExtractedQuantity = (ironOreExtractedQuantity * buffGainPercentage).toInt()

    println("Получено дополнительно кристаллической руды: $crystalOreBonusExtractedQuantity")
    println("Получено дополнительно железной руды: $ironOreBonusExtractedQuantity")
}