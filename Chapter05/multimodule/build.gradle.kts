plugins {
    base
    kotlin("jvm") version "1.3.21" apply false
}

allprojects {

    group = "kotlinguide"

    version = "1.0"

    repositories {
        jcenter()
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
