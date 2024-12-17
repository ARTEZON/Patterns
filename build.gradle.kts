plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
    java
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "me.artezon.labs.patterns"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("com.charleskorn.kaml:kaml:0.61.0")
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
    implementation("org.slf4j:slf4j-reload4j:2.0.16")
    implementation("org.openjfx:javafx-controls:23.0.1")
    implementation("org.openjfx:javafx-fxml:23.0.1")
}

javafx {
    version = "23"
    modules = listOf("javafx.controls", "javafx.fxml") // Add more modules as needed
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}