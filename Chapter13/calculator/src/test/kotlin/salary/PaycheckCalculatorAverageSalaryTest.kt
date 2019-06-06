package salary

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import com.nhaarman.mockitokotlin2.eq

class PaycheckCalculatorAverageSalaryTest {
    @Test
    fun `test calculate correct with mockito-kotlin`() {
        val salaryDatabase: SalaryDatabase = mock()
        whenever(salaryDatabase.getAllSalaries()).thenReturn(listOf(5000.0, 10000.0, 15000.0))
        val calculator = PaycheckCalculator(salaryDatabase)
        assertEquals(10000.0, calculator.calculateAverageSalary())
        verify(salaryDatabase).getAllSalaries()
    }
}