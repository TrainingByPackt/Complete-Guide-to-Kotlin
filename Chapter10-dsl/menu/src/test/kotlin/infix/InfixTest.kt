package infix

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import infix.MenuBuilder.bread
import infix.MenuBuilder.ingredients
import infix.MenuBuilder.condiments
import infix.MenuBuilder.CondimentType.mayonnaise
import infix.MenuBuilder.CondimentType.mustard
import infix.MenuBuilder.BreadType.wheat

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

    @Test
    fun `without ingredient`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder {
            "blt" has "bacon"
            "blt" has "lettuce"
            "blt" has "tomato"

            "blt" without "bacon"
        }
        assertThat(menu.dishes[0].name).isEqualTo("blt")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(2)
    }

    @Test
    fun `with bread`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder {
            "blt" with ingredients named "bacon"
            "blt" with bread named wheat
        }
        assertThat(menu.dishes[0].name).isEqualTo("blt")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(2)
    }

}