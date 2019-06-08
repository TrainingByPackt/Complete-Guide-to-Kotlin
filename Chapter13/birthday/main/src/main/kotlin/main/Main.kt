package main

import birthday.BirthdayCalculator

fun main() {
    val calc = BirthdayCalculator(1980, 12, 5)
    println("age: ${calc.age()}")
    println("day of the week: ${calc.dayOfTheWeek()}")
    println("days until: ${calc.daysUntil()}")

}
