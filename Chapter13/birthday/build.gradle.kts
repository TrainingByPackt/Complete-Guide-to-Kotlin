plugins {
    kotlin("jvm") version "1.3.21" apply false
}
//    base, should add the check and build task or maybe it is here by default 

allprojects {
    group = "kotlinguide"

    version = "1.0"

    repositories {
        jcenter()
    }
}

subprojects {
//	apply(kotlin("jvm") version "1.3.21")
//     if (name.startsWith("hello")) {
//         apply(plugin = "org.gradle.sample.hello")
//     }
}

dependencies {

    compile(kotlin("stdlib"))

    subprojects.forEach {
        archives(it)
    }
}
