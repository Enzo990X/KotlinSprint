package org.example.lesson_22

fun main() {

    val mainScreenViewModel = MainScreenViewModel()
    mainScreenViewModel.loadData()
}

class MainScreenViewModel() {
    private var mainScreenState = MainScreenState(null, false)

    fun loadData() {

        mainScreenState = mainScreenState.copy(data = null, isLoading = false)
        println("Отсутствие данных")
        Thread.sleep(SLEEP)

        mainScreenState = mainScreenState.copy(isLoading = true)
        println("Загрузка данных")
        Thread.sleep(SLEEP)

        mainScreenState = mainScreenState.copy(data = "Loaded Data", isLoading = false)
        println("Наличие загруженных данных")
    }
}

data class MainScreenState(val data: String?, val isLoading: Boolean = false)

private const val SLEEP = 1000L
