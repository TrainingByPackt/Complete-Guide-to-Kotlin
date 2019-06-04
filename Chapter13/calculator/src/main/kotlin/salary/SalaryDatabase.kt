package salary

import java.lang.IllegalArgumentException

class SalaryDatabase {
    private val salaries = mapOf("Patricia" to 10000.0, "Bonita" to 26000.0)

    fun lookupSalary(name: String?): Double = salaries[name] ?: throw IllegalArgumentException("Unknown Person")
}