package org.example.lesson_22

fun main () {

    val place = GalacticGuide ("Альфа Центавра",
        "Расположено по линии Большая Медведица — Дева к югу от небесного экватора на 40—50°.",
        "15-05-2025 15:05",
        4.367f)


    println("Созвездие ${place.component1()} изучено ${place.component3()}. " +
            "${place.component2()} Расстояние до Земли ${place.component4()} световых лет.")
}

data class GalacticGuide (
    val name: String,
    val description: String,
    var date: String,
    val distanceToEarth: Float,
)
