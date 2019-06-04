package calculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorAbsoluteSquareRootWithAssertTest {
    lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `test computes square root`() {
        assertThat(calculator.absoluteSquareRoot(4.0)).isEqualTo(2.0)
    }

    @Test
    fun `test computes square root of negative`() {
        assertThat(calculator.absoluteSquareRoot(-4.0)).isEqualTo(2.0)
    }

    @Test
    fun `test negative number does not produce NaN`() {
        assertThat(calculator.absoluteSquareRoot(-1.0)).isNotEqualTo(Double.NaN)
    }
}