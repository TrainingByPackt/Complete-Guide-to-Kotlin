import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktlint: Configuration by configurations.creating

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "kotlinguide"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    ktlint("com.pinterest:ktlint:0.33.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


tasks.register<JavaExec>("ktlint") {
    group = "verification"
    description = "Check Kotlin code style."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args("src/**/*.kt")
}

tasks.register<JavaExec>("ktlintFormat") {
    group = "formatting"
    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args("-F", "src/**/*.kt")
}

tasks.getByName("check").dependsOn("ktlint")
