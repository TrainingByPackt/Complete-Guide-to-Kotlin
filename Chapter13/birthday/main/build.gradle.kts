plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "main.MainKt"
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib"))
}
