package builder

class BurgerBuilder(val menu: MenuBuilder) {
    enum class Patty {
        beef,
        turkey,
        vegetarian
    }

    fun patty(patty: Patty): BurgerBuilder {
        menu.add(patty.name)
        return this
    }
}
