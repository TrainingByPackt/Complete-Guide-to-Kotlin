package infix

import model.Dish
import model.Menu

class DishBuilder() {
    var name = ""
    val ingredients = mutableListOf<String>()

    fun name(name: String): DishBuilder {
        this.name = name
        return this
    }

    fun add(ingredient: String): DishBuilder {
        ingredients.add(ingredient)
        return this
    }

    fun build(): Dish {
        return Dish(name, ingredients)
    }
}

