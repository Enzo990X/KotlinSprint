package org.example.lesson_2

fun main() {
    val numberOfEmployees = 50
    val employeeSalary = 30000
    val numberOfInterns = 30
    val internSalary = 20000

    val allEmployeesSalary = employeeSalary * numberOfEmployees
    val totalSalary = employeeSalary * numberOfEmployees + internSalary * numberOfInterns
    val averageSalary = totalSalary / (numberOfEmployees + numberOfInterns)

    println("Расходы на выплату зарплаты постоянных сотрудников: $allEmployeesSalary рублей")
    println("Общие расходы по зарплате после прихода стажеров: $totalSalary рублей")
    println("Средняя зарплата после прихода стажеров: $averageSalary рублей")

}