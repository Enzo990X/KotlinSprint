package org.example.lesson_19

fun main() {
    val tank = Tank()

    println("Орудие не заряжено.")
    tank.swapAmmunition()

    println("\nПриступаем к стрельбам.")
    while (true) {
        tank.fire()
        Tank.totalDamage += tank.ammunition!!.damage

        println("Хотите продолжить стрельбу?")
        var answer = readln()

        if (answer == "да") {
            println("\nХотите заменить боеприпас?")
            answer = readln()

            if (answer == "да") tank.swapAmmunition()
            continue
        } else break
    }
    println("\nСтрельбы окончены. Вы нанесли ${Tank.totalDamage} единиц урона.")
}

enum class Ammunition(val damage: Int) {
    BLUE(5) ,
    GREEN(10) ,
    RED(20);
}

class Tank(var ammunition: Ammunition? = null) {

    companion object {
        var totalDamage = 0
    }

    fun swapAmmunition() {
        println("Выберите тип боеприпасов: 1 - синие, 2 - зеленые, 3 - красные.")
        var newAmmunition = readln()

        while (newAmmunition != "1" && newAmmunition != "2" && newAmmunition != "3") {
            println("\nНеверный ввод. Повторите попытку.")
            newAmmunition = readln()
        }

        this.ammunition = when (newAmmunition) {
            "1" -> Ammunition.BLUE
            "2" -> Ammunition.GREEN
            "3" -> Ammunition.RED
            else -> {
                println("\nНет снаряда - нет стрельбы.")
                return
            }
        }
    }

    fun fire() {
        ammunition?.let {
            println("\nВыстрел нанёс ${ammunition!!.damage} единиц урона.")
        }
    }
}
