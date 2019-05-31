package infix

import org.junit.jupiter.api.Test
import infix.MenuBuilder.ingredients
import infix.MenuBuilder.condiments
import infix.MenuBuilder.CondimentType.mayonnaise
import infix.MenuBuilder.CondimentType.mustard

class InfixTest {
    @Test
    fun `hello sections`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        builder {
            "blt" has "bacon"
            "blt" has "lettuce"
            "blt" has "tomato"

            "pizza" has "cheese"
            "pizza" has "pepperoni"

            "blt" with ingredients named "bacon"
            "blt" with condiments named mayonnaise
            "blt" with condiments named mustard

            "blt" with ingredients named "bacon" and "lettuce" and "tomato"
            "blt" with condiments named mayonnaise and mustard

            "blt" with ingredients named "bacon" and "lettuce" and "tomato" and condiments named mayonnaise and mustard
        }
    }
}