plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "main.MainKt"
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib", "1.3.31"))
}
