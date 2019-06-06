plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "main.Main"
}

dependencies {
    compile(project(":core"))
    compile(kotlin("stdlib"))
}
