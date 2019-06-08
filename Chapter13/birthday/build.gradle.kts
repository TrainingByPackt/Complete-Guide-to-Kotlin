plugins {
    base
    kotlin("jvm") version Config.Versions.kotlin apply false
}

allprojects {
    repositories {
        jcenter()
    }
}

