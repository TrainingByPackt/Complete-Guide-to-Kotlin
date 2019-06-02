package salary

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import com.nhaarman.mockitokotlin2.eq

class PaycheckCalculatorTestWithMockito {
    @Test
    fun `test calculate correct with mockito-kotlin`() {
        val salaryDatabase: SalaryDatabase = mock()
        whenever(salaryDatabase.lookupSalary(eq("Bonita"))).thenReturn(26000.0)
        val calculator = PaycheckCalculator(salaryDatabase)
        assertEquals(1000.0, calculator.calculateSalary("Bonita"))
        verify(salaryDatabase).lookupSalary("Bonita")
    }
}