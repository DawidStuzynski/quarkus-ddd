plugins {
    kotlin("jvm") version "2.0.10"
    kotlin("plugin.allopen") version "2.0.10"
    id("java")
    id("org.kordamp.gradle.jandex") version "2.0.0"
//    id("io.quarkus") apply false
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.kordamp.gradle.jandex")
//    apply(plugin = "io.quarkus")

    repositories {
        mavenCentral()
        mavenLocal()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<Test> {
        systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    }

    allOpen {
        annotation("jakarta.ws.rs.Path")
        annotation("jakarta.enterprise.context.ApplicationScoped")
        annotation("jakarta.persistence.Entity")
        annotation("io.quarkus.test.junit.QuarkusTest")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_21.toString()
        kotlinOptions.javaParameters = true
    }
}
