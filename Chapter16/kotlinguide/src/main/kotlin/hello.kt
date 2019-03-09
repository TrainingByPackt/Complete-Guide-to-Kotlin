fun main(args: Array<String>) {
    Hello().say()
}

class Hello {
    fun say() {
        println("hello!")
    }
}

//Gregs-MacBook-Pro:kotlinguide greg$ ./gradlew --console=plain build
//> Task :compileKotlin UP-TO-DATE
//> Task :compileJava NO-SOURCE
//> Task :processResources NO-SOURCE
//> Task :classes UP-TO-DATE
//> Task :inspectClassesForKotlinIC UP-TO-DATE
//> Task :jar UP-TO-DATE
//> Task :assemble UP-TO-DATE
//> Task :compileTestKotlin NO-SOURCE
//> Task :compileTestJava NO-SOURCE
//> Task :processTestResources NO-SOURCE
//> Task :testClasses UP-TO-DATE
//> Task :test NO-SOURCE
//> Task :check UP-TO-DATE
//> Task :build UP-TO-DATE