package builder

import model.Menu

class MenuBuilder(private val name:String) {
    var lastIngredient: String? = null
    var currentDish: String? = null

    private val dishes = mutableMapOf<String, DishBuilder>()

    // builder style
    fun add(dishName: String, ingredient: String): MenuBuilder {
        getOrCreate(dishName).add(ingredient)
        return this
    }

    private fun getOrCreate(dishName: String): DishBuilder {
        var ingredients = dishes[dishName]
        if (ingredients == null) {
            ingredients = DishBuilder()
            dishes[dishName] = ingredients
        }
        return ingredients
    }

    // uses the add context
    fun add(ingredient: String): MenuBuilder {
        lastIngredient = ingredient
        currentDish?.let {
            getOrCreate(it).add(ingredient)
        } ?: throw Exception("currentDish not set")
        return this
    }

    fun extra(): MenuBuilder {
        lastIngredient?.let {
            add(it)
        } ?: throw Exception("lastIngredient not set")
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

    fun asBurger(): BurgerBuilder = BurgerBuilder(this)

    fun build(): Menu {
        val dishes = dishes.map { it.value.build() }
        return Menu(name, dishes)
    }
}

