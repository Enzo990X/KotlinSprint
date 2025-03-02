package org.example.lesson_2

fun main() {

    val grade1 = 3f
    val grade2 = 4f
    val grade3 = 3f
    val grade4 = 5f
    val numberOfGrades = 4

    val averageGrade = (grade1 + grade2 + grade3 + grade4) / numberOfGrades

    println("$averageGrade")

    /*
    val pupil1 = Pupils(3f)
    val pupil2 = Pupils(4f)
    val pupil3 = Pupils(3f)
    val pupil4 = Pupils(5f)

    val averageGrade = (pupil1.grade + pupil2.grade + pupil3.grade + pupil4.grade) / Pupils.numberOfPupils

    println("$averageGrade")
}

class Pupils(val grade: Float) {

    companion object {
        var numberOfPupils:Int = 0
    }

    init {
        numberOfPupils++
    }
     */
}