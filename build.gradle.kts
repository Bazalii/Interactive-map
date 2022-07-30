import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.allopen") version "1.6.21"
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    group = "org.mapins"
    version = "1.0.0-SNAPSHOT"
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}