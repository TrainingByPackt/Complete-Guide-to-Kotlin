package builder

import org.junit.jupiter.api.Test
import infix.MenuBuilder
import infix.MenuBuilder.ingredients
import infix.MenuBuilder.condiments
import infix.MenuBuilder.CondimentType.*

class InfixTest {
    @Test
    fun `hello sections`() {
        val builder = MenuBuilder("Sunshine")
        builder.create {
            "blt" has "bacon"
            "blt" has "lettuce"
            "blt" has "tomato"

            "pizza" has "cheese"
            "pizza" has "pepperoni"

            "blt" with ingredients named "bacon"
            "blt" with condiments named mayonnaise
            "blt" with condiments named mustard

            "blt" with ingredients first "bacon" then "lettuce" then "tomato"
            "blt" with condiments named mayonnaise and mustard

            "blt" with ingredients first "bacon" then "lettuce" then "tomato" and condiments named mayonnaise and mustard
        }
    }
}