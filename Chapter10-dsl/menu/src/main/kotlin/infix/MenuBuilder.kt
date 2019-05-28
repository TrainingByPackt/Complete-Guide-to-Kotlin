package infix

import model.Dish
import model.Menu

class MenuBuilder(private val name: String) {
    val dishBuilders = mutableMapOf<String, DishBuilder>()

    operator fun invoke(block: MenuBuilder.() -> Unit) {
        block()
    }

    fun dish(name: String, block: DishBuilder.() -> Unit): DishBuilder {
        val builder = DishBuilder()
        dishBuilders[name] = builder
        builder.block()
        return builder
    }

    infix fun String.has(ingredient: String) {
        dishBuilders[this]?.add(ingredient)
    }

    object condiments
    object ingredients

    enum class CondimentType {
        mayonnaise, mustard
    }

    infix fun String.with(ingredient: ingredients): IngredientAdder =
        IngredientAdder(dishBuilders[this] ?: dish(this, {}))
    infix fun String.with(condiment: condiments): CondimentAdder =
        CondimentAdder(dishBuilders[this] ?: dish(this, {}))

    class IngredientAdder(private val dish: DishBuilder) {
        infix fun named(ingredient: String): IngredientAdder {
            dish.add(ingredient)
            return this
        }

        infix fun first(ingredient: String): IngredientAdder {
            dish.add(ingredient)
            return this
        }

        infix fun then(ingredient: String): IngredientAdder {
            dish.add(ingredient)
            return this
        }

        infix fun and(condiment: condiments): CondimentAdder = CondimentAdder(dish)
    }

    class CondimentAdder(private val dish: DishBuilder) {
        infix fun named(condiment: CondimentType): CondimentAdder {
            dish.add(condiment.name)
            return this
        }

        infix fun and(condiment: CondimentType): CondimentAdder {
            dish.add(condiment.name)
            return this
        }
    }

    fun create(block: MenuBuilder.() -> Unit): Menu {
        block()
        return build()
    }

    fun build(): Menu {
        val dishes = dishBuilders.map { it.value.build() }
        return Menu(name, dishes)
    }
}