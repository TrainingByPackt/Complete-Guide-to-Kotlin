import org.junit.jupiter.api.Test

import assertk.assertThat
import assertk.assertions.isEqualTo

class AdditionTest {
    @Test
    fun `test 1 plus 1 is 2`() {
        assertThat(1+1).isEqualTo(2)
    }

    @Test
    fun `test 2 plus 2 is 6`() {
        assertThat(2+2).isEqualTo(6)
    }
}