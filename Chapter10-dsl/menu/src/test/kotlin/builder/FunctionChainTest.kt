package builder

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import builder.PizzaBuilder.Topping.*
import builder.SandwichBuilder.Topping.*
import builder.SandwichBuilder.Condiment.*

class FunctionChainTest {
//    @Test
//    fun `create menu with dish`() {
//        val menu = MenuBuilder("Sunshine")
//
//        val builder = DishBuilder()
//        val blt = builder.name("blt").add("bacon").add("lettuce").add("tomato").build()
//        menu.add(blt)
//
//        assertThat(dish.name).isEqualTo("blt")
//        assertThat(dish.ingredients.size).isEqualTo(3)
//    }

    @Test
    fun `create menu with function chain`() {
        val builder = MenuBuilder("Sunshine")

        builder.add("blt", "bacon")
            .add("blt", "lettuce")
            .add("blt", "tomato")

        val menu = builder.build()

        assertThat(menu.dishes[0].name).isEqualTo("blt")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    // exercise
    @Test
    fun `create menu with pizza with function chain`() {
        val builder = MenuBuilder("Sunshine")

        builder.add("pizza", "cheese")
            .add("pizza", "pepperoni")
            .add("pizza", "mushroom")

        val menu = builder.build()

        assertThat(menu.dishes[0].name).isEqualTo("pizza")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }


    @Test
    fun `create menu with context variable`() {
        val menu = MenuBuilder("Sunshine")
            .dish("blt").add("bacon").add("lettuce").add("tomato")
            .dish("pizza").add("cheese").add("pepperoni").add("mushroom")
            .build()

        assertThat(menu.dishes[0].name).isEqualTo("blt")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)
    }

    @Test
    fun `create menu with nested builders`() {
        val builder = MenuBuilder("Sunshine")

        builder.dish("ham and cheese").add("cheese").asSandwich().topping(ham).condiment(mayonnaise)
        builder.dish("pizza").add("cheese").asPizza().topping(pepperoni).topping(mushrooms)

        val menu = builder.build()

        assertThat(menu.dishes[0].name).isEqualTo("ham and cheese")
        assertThat(menu.dishes[0].ingredients.size).isEqualTo(3)

        assertThat(menu.dishes[1].name).isEqualTo("pizza")
        assertThat(menu.dishes[1].ingredients.size).isEqualTo(2)
    }

    @Test
    fun `lookup dishes using symbols`() {
        val builder = MenuBuilder("Sunrise")

        val menu = builder
            .add("blt", "bacon")
            .add("blt", "lettuce")
            .add("blt", "tomato")
    }
}