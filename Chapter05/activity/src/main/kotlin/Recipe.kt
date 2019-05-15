class Recipe(val name: String) {
    var done: Boolean = false

    fun start() {
        println("started $name")
    }

    fun stop() {
        println("stopped $name")
        done = true
    }
}