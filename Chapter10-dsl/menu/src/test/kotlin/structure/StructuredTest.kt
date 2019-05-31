package structure

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import structure.DishBuilder.Size.small
import structure.DishBuilder.Topping.pepperoni
import structure.DishBuilder.Topping.onions
import structure.DishBuilder.Topping.mushrooms

class StructuredTest {
    @Test
    fun `create two menu`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            dish("pizza") {
                +"cheese"
                +"pepperoni"
                +"mushroom"
            }
            dish("blt") {
                bacon
                lettuce
                tomato
            }
        }
    }

    @Test
    fun `create single section menu`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            // lambda
            dish("pizza") {
                add("cheese")
                add("pepperoni")
                add("mushroom")
                // assignment with enum and static import
                size = small
            }
            // using operator
            dish("veggie pizza") {
                +"mushroom"
                +"onion"
                +"peppers"
            }
            // using properties
            dish("blt") {
                bacon
                lettuce
                tomato
            }
            // extension function
            "tofu scramble".has {
                +"tofu"
                +"avocado"
                +"tomato"
            }
        }
        assertThat(menu.dishes.size).isEqualTo(4)
        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[1].name).isEqualTo("veggie pizza")
        menu.dishes.forEach {
            assertThat(it.ingredients.size).isEqualTo(3)
        }
    }

    @Test
    fun `create menu with pizza`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            // lambda
            dish("pizza") {
                add("cheese")
                add("pepperoni")
                add("mushroom")
            }
        }
        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    @Test
    fun `create menu with dish invoke`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {

            val pizza = dish("pizza", {})
            pizza("cheese")
            pizza("pepperoni")
            pizza("mushroom")
        }
        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    @Test
    fun `create menu with vegetarian pizza`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            dish("vegetarian pizza") {
                add("peppers")
                add("sun dried tomatos")
                add("basil")
            }
        }
        assertThat(menu.dishes[0].name).isEqualTo("vegetarian pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    @Test
    fun `create menu with pizza topping enum`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            dish("pizza") {
                +pepperoni
                +onions
                +mushrooms
            }
        }
        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    @Test
    fun `test dsl marker`() {
        val builder = MenuBuilder("Sunrise Restaurant")
        val menu = builder.create {
            // lambda
            dish("pizza") {
                add("cheese")
                add("pepperoni")
                add("mushroom")
                // fails because of @DSLMarker
//                dish ("another pizza") {
//                    add("cheese")
//                }
            }
        }
        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }
}