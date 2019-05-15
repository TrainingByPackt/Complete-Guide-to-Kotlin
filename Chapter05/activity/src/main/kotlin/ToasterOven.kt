// SOLUTION
class ToasterOven {
    private lateinit var recipe:Recipe

    fun start(recipe: Recipe) {
        this.recipe = recipe

        recipe.start()
    }

    fun stop() {
        recipe.stop()
    }
}