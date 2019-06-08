plugins {
    base
    kotlin("jvm") version Config.Version.kotlin apply false
}

allprojects {
    repositories {
        jcenter()
    }
}

