package org.example.lesson_21


fun main() {

    val player = OneMorePlayer(
        "Сорака", mutableMapOf(
            "Спасение" to 3,
            "Звездопад" to 5,
            "Звездная пыль" to 2,
            "Равноденствие" to 5,
            "Желание" to 4
        )
    )

    repeat(3) { player.getNewLevel() }

    println("Наибольшее количество опыта в навыке: ${player.skillset.maxCategory()}")
}

fun Map<String, Int>.maxCategory(): String? {

    return this.maxByOrNull { it.value }?.key
}

class OneMorePlayer(
    val name: String,
    val skillset: MutableMap<String, Int>,
) {

    fun getNewLevel() {

        println("Получен новый уровень. Какой навык Вы хотите улучшить?")
        var inputForSkill = readln()

        while (!skillset.keys.any { it.equals(inputForSkill, ignoreCase = true) }) {
            println("Ошибка. Повторите ввод.")
            inputForSkill = readln()
        }

        val currentSkillValue = skillset[inputForSkill] ?: 0
        val updatedSkillValue = currentSkillValue + 1
        skillset[inputForSkill] = updatedSkillValue

        println("Навык '$inputForSkill' обновлен до значения: $updatedSkillValue")
    }
}
