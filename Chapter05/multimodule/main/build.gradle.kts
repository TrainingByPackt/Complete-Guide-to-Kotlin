plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "main.Main"
}

dependencies {
    compile(project(":bank"))
    compile(kotlin("stdlib"))
}
