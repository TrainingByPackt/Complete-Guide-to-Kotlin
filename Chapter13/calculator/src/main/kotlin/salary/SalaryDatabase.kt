package salary

import java.lang.IllegalArgumentException

class SalaryDatabase {
    private val salaries = mapOf("Patricia" to 10000.0, "Bonita" to 26000.0, "Scott" to 5000.0)

    fun getAllSalaries(): List<Double> = salaries.map { it.value }

    fun lookupSalary(name: String?): Double = salaries[name] ?: throw IllegalArgumentException("Unknown Person")
}