package org.example.lesson_20

fun main() {
    val products = listOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")

    val message: (String) -> Unit = { println("Нажат элемент $it") }

    val onClick = products.map { product ->
        { message(product) }
    }

    for (i in onClick.indices) {
        if (i % 2 == 0) onClick[i + 1]()
    }
}
