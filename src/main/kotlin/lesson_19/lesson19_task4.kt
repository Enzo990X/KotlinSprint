package org.example.lesson_19

fun main() {
    val tank = Tank(Ammunition.BLUE)

    println("В Вашем орудии заряжен ${tank.ammunition.getName()} боеприпас. Хотите его заменить?")
    val answer = readln()
    if (answer == "да") tank.swapAmmunition()

    println("\nПриступаем к стрельбам.")
    while (true) {
        tank.fire()
        Tank.totalDamage += tank.ammunition.getDamage()

        println("\nХотите продолжить стрельбу?")
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


enum class Ammunition(val id: Int) {
    BLUE(1) {
        override fun getName(): String = "синий"
        override fun getDamage(): Int = 5
    },
    GREEN(2) {
        override fun getName(): String = "зеленый"
        override fun getDamage(): Int = 10
    },
    RED(3) {
        override fun getName(): String = "красный"
        override fun getDamage(): Int = 20
    };

    abstract fun getName(): String
    abstract fun getDamage(): Int
}

class Tank(var ammunition: Ammunition) {

    companion object {
        var totalDamage = 0
    }

    fun swapAmmunition() {
        println("\nВыберите тип боеприпасов: 1 - синие, 2 - зеленые, 3 - красные.")
        var newAmmunition = readln()

        while (newAmmunition != "1" && newAmmunition != "2" && newAmmunition != "3") {
            println("\nНеверный ввод. Повторите попытку.")
            newAmmunition = readln()
        }

        this.ammunition = when (newAmmunition) {
            "1" -> Ammunition.BLUE
            "2" -> Ammunition.GREEN
            "3" -> Ammunition.RED
            else -> ammunition
        }
    }

    fun fire() {
        ammunition.getDamage()
        println("\nВыстрел нанёс ${ammunition.getDamage()} единиц урона.")
    }
}
