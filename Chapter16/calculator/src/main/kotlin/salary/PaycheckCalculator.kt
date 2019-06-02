package salary

class PaycheckCalculator(val database: SalaryDatabase) {
    fun calculateSalary(name: String): Double =
        database.lookupSalary(name) / 26.0
}