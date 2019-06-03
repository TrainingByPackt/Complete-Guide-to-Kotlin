package salary

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PaycheckCalculatorTest {
    @Test
    fun `test calculate correct no mock`() {
        val salaryDatabase = SalaryDatabase()
        val calculator = PaycheckCalculator(salaryDatabase)
        assertEquals(1000.0, calculator.calculateSalary("Bonita"))
    }

    @Test
    fun `test calculate correct with mock`() {
        val salaryDatabase = mock(SalaryDatabase::class.java)
        `when`(salaryDatabase.lookupSalary(eq("Bonita"))).thenReturn(26000.0)
        val calculator = PaycheckCalculator(salaryDatabase)
        assertEquals(1000.0, calculator.calculateSalary("Bonita"))
        verify(salaryDatabase).lookupSalary("Bonita")
    }


}