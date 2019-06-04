import org.apache.commons.math3.stat.StatUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathTest {
    @Test
    fun runT() {
        assertEquals(2.0, StatUtils.mean(doubleArrayOf(1.0, 2.0, 3.0)))
    }
}