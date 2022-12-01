import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "uk.co.alistaironeill"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val strikt : String by project

dependencies {
    testImplementation("io.strikt", "strikt-core", strikt)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
