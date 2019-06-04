package calculator

import assertk.all
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isGreaterThanOrEqualTo
import assertk.assertions.isLessThan
import assertk.assertions.isNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `test 4 divided by 2 is 2`() {
        assertEquals(2.0, calculator.divide(4.0, 2.0))
    }

    @Test
    fun `test divide by zero produces an exception`() {
        assertThrows<ArithmeticException> {
            calculator.divide(4.0, 0.0)
        }
    }

    @Test
    fun `test various division problems`() {
        assertAll("Division",
            { assertEquals(2.0, calculator.divide(4.0, 2.0)) },
            { assertEquals(3.0, calculator.divide(6.0, 2.0)) },
            { assertEquals(4.0, calculator.divide(8.0, 2.0)) }
        )
    }

    @Test
    fun `test assertk`() {
        val number = 2.0
        assertEquals(2.0, number)

        assertThat(number).isEqualTo(2.0)
    }

    @Test
    fun `test assertk chain`() {
        assertThat(calculator.divide(4.0, 2.0)).isNotNull().isGreaterThanOrEqualTo(2.0)
    }

    @Test
    fun `test assertk all`() {
        assertThat(calculator.divide(4.0, 2.0)).all {
            isGreaterThanOrEqualTo(2.0)
            isLessThan(4.0)
        }
    }

}