plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "ui.BirthdayAppMainKt"
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib"))
    implementation("no.tornado:tornadofx:1.7.19")
}
