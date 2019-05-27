package structure

import model.Dish

@MenuBuilderDsl
class DishBuilder() {
    enum class Size {
        small,
        large
    }

    var name = ""
    var size: Size = Size.small
    val ingredients = mutableListOf<String>()

    val bacon: Boolean
        get() {
            ingredients.add("bacon")
            return true
        }

    val lettuce: Boolean
        get() {
            ingredients.add("lettuce")
            return true
        }

    val tomato: Boolean
        get() {
            ingredients.add("tomato")
            return true
        }

    fun name(name: String): DishBuilder {
        this.name = name
        return this
    }

    fun add(ingredient: String): DishBuilder {
        ingredients.add(ingredient)
        return this
    }

    operator fun String.unaryPlus() {
        ingredients.add(this)
    }

    fun build(): Dish {
        return Dish(name, ingredients)
    }
}

