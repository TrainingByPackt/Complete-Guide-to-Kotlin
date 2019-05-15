import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OvenTest {
    @Test
    fun `cook potatos`() {
        val oven = ToasterOven()
        val potatoRecipe = Recipe("potatos")
        oven.start(potatoRecipe)
        oven.stop()

        assertTrue(potatoRecipe.done)
    }
}