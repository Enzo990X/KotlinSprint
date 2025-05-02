package org.example.lesson_22

fun main () {

    val place = GalacticGuide ("Альфа Центавра",
        "Расположено по линии Большая Медведица — Дева к югу от небесного экватора на 40—50°.",
        "15-05-2025 15:05",
        4.367f)

    println(place.toString())
}

data class GalacticGuide (
    val name: String,
    val description: String,
    var date: String,
    val distanceToEarth: Float,
) {
    override fun toString(): String {
        return "Созвездие $name изучено $date. $description Расстояние до Земли $distanceToEarth световых лет"
    }
}
