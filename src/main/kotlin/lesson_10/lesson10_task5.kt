package org.example.lesson_10

fun main() {

    var token = login()
    while (token == null) {
        println("Ошибка входа в систему. Повторите попытку.\n")
        token = login()
    }

    getCart(token)
}

fun login(): String? {
    println("Вход")
    println("Введите имя пользователя: ")
    getUserName = readln()

    println("Введите пароль: ")
    getPassword = readln()

    if (getUserName == USER_NAME && getPassword == PASSWORD) {
        val symbolRange = FIRST_SYMBOL..LAST_SYMBOL
        var symbol: Int
        val charSmallCharRange = FIRST_SMALL_CHAR..LAST_SMALL_CHAR
        var smallChar: Char
        val charBigCharRange = FIRST_BIG_CHAR..LAST_BIG_CHAR
        var bigChar: Char

        val range = RANGE_START..RANGE_END
        var token = ""

        for (i in range) {
            symbol = symbolRange.random()
            smallChar = charSmallCharRange.random()
            bigChar = charBigCharRange.random()
            val tokenChar = listOf(symbol, smallChar, bigChar).random()
            token += tokenChar
        }
        return token
    } else return null
}

fun getCart(token: String?) {

    println("Ваш токен: $token")

    val cart = arrayOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")
    println("Ваша корзина: ${cart.joinToString()}")
}

private var getUserName = ""
private var getPassword = ""

private const val USER_NAME: String = "admin"
private const val PASSWORD: String = "password"
private const val FIRST_SYMBOL = 0
private const val LAST_SYMBOL = 9
private const val FIRST_SMALL_CHAR = 'a'
private const val LAST_SMALL_CHAR = 'z'
private const val FIRST_BIG_CHAR = 'A'
private const val LAST_BIG_CHAR = 'Z'
private const val RANGE_START = 0
private const val RANGE_END = 32
