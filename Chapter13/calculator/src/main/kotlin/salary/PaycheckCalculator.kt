package salary

class PaycheckCalculator(val database: SalaryDatabase) {
    fun calculateSalary(name: String): Double =
        database.lookupSalary(name) / 26.0

    fun calculateAverageSalary(): Double {
        val salaries = database.getAllSalaries()
        val total = salaries.fold(0.0, { total, next -> total + next })
        return total / salaries.size.toDouble()
    }
}