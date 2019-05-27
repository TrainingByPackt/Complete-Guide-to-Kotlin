package builder

class SandwichBuilder(val menu: MenuBuilder) {
    enum class Topping {
        ham,
        lettuce
    }

    enum class Condiment {
        mayonase,
        mustard
    }

    fun topping(topping: Topping): SandwichBuilder {
        menu.add(topping.name)
        return this
    }

    fun condiment(condiment: Condiment): SandwichBuilder {
        menu.add(condiment.name)
        return this
    }
}