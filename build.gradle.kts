plugins {
    kotlin("jvm") version "2.0.21" apply false
}

group = "com.motycka.edu"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        mavenLocal()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
