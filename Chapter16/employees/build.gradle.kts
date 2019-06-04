import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.30"
}

group = "kotlinguide"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.4.2")

    implementation("org.apache.commons:commons-math3:3.6")
//    implementation(group = "org.apache.commons", name="commons-math3", version = "3.6")

    //https://github.com/MicroUtils/kotlin-logging
    implementation("io.github.microutils:kotlin-logging:1.6.24")
    implementation(group = "org.slf4j", name="slf4j-api", version = "1.7.21")
    implementation("org.slf4j:slf4j-simple:1.7.26")

    // https://mvnrepository.com/artifact/no.tornado/tornadofx
    implementation(group="no.tornado", name="tornadofx", version="1.7.19")
//    implementation( group = "kotlin-logging", name = "io.github.microutils", version = "1.6.24")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}