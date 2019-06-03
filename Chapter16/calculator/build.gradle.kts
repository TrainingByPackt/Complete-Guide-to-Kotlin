import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testCompile("com.willowtreeapps.assertk:assertk-jvm:0.17")
    testCompile("org.mockito:mockito-inline:2.28.2")
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}