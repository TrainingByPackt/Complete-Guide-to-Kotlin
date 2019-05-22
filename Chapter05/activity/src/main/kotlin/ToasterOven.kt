// SOLUTION
class ToasterOven: Oven {
    private lateinit var recipe:Recipe

    override fun start(recipe: Recipe) {
        this.recipe = recipe

        recipe.start()
    }

    override fun stop() {
        recipe.stop()
    }
}