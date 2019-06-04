package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorAbsoluteSquareRootTest {
    lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `test computes square root`() {
        assertEquals(2.0, calculator.absoluteSquareRoot(4.0))
    }

    @Test
    fun `test computes square root of negative`() {
        assertEquals(2.0, calculator.absoluteSquareRoot(-4.0))
    }

    @Test
    fun `test negative number does not produce NaN`() {
        val root = calculator.absoluteSquareRoot(-1.0)
        assertNotEquals(Double.NaN, root)
    }
}