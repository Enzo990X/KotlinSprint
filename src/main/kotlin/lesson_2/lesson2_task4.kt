package org.example.lesson_2

fun main() {
    val buffGainPercentage = 20
    val crystalOreExtractedQuantity = 7
    val ironOreExtractedQuantity = 11

    val crystalOreBonusExtractedQuantity = (crystalOreExtractedQuantity * buffGainPercentage) / TOTAL_PERCENTAGE
    val ironOreBonusExtractedQuantity = (ironOreExtractedQuantity * buffGainPercentage) / TOTAL_PERCENTAGE

    println("Получено дополнительно кристаллической руды: $crystalOreBonusExtractedQuantity")
    println("Получено дополнительно железной руды: $ironOreBonusExtractedQuantity")
}

const val TOTAL_PERCENTAGE = 100