package builder

import model.Dish
import model.Menu

class MenuBuilder(private val name:String) {
    var currentDish: String? = null

    private val dishes = mutableMapOf<String, MutableList<String>>()

    // builder style
    fun add(dishName: String, ingredient: String): MenuBuilder {
        getOrCreate(dishName).add(ingredient)
        return this
    }

    private fun getOrCreate(dishName: String): MutableList<String> {
        var ingredients = dishes[dishName]
        if (ingredients == null) {
            ingredients = mutableListOf()
        }
        return ingredients
    }

    // uses the add context
    fun add(ingredient: String): MenuBuilder {
        currentDish?.let {
            getOrCreate(it).add(ingredient)
        } ?: throw Exception("currentDish not set")
        return this
    }

    // set the context variable for which dish we are making
    fun dish(dishName: String): MenuBuilder {
        currentDish = dishName
        return this
    }

    // nested builders
    fun asPizza(): PizzaBuilder = PizzaBuilder(this)

    fun asSandwich(): SandwichBuilder = SandwichBuilder(this)

    fun build(): Menu {
        val dishes = dishes.map { Dish(it.key, it.value) }
        return Menu(name, dishes)
    }
}

