plugins {
//    kotlin("jvm") version "2.0.10"
    id("io.quarkus")
//    id("java")
}

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.named("quarkusDependenciesBuild") {
    inputs.files(tasks.getByPath(":infrastructure:jandex").outputs.files)
}
tasks.named("quarkusGenerateCodeTests") {
    inputs.files(tasks.getByPath(":infrastructure:jandex").outputs.files)
}


val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("$quarkusPlatformGroupId:$quarkusPlatformArtifactId:$quarkusPlatformVersion"))
    implementation(project(":domain"))
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

//sourceSets {
//    main {
//        java {
//            setSrcDirs(listOf("infrastructure/src/main/kotlin"))
//        }
//        resources {
//            setSrcDirs(listOf("infrastructure/src/main/resources"))
//        }
//    }
//    test {
//        java {
//            setSrcDirs(listOf("infrastructure/src/test/kotlin"))
//        }
//        resources {
//            setSrcDirs(listOf("infrastructure/src/test/resources"))
//        }
//    }
//}



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