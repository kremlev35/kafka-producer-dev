import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    val kotlinVersion = "1.5.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}

group = "me.nkremlev"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    // Spring dependencies
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-webflux")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-actuator")
    implementation(group = "org.springframework.kafka", name = "spring-kafka")

    // Open-api dependencies
    api(group = "org.springdoc", name = "springdoc-openapi-webflux-core", version = "1.4.0")
    api(group = "org.springdoc", name = "springdoc-openapi-kotlin", version = "1.4.0")
    api(group = "org.springdoc", name = "springdoc-openapi-webflux-ui", version = "1.4.0")

    // Kotlin dependencies
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    implementation(group = "io.projectreactor.kotlin", name = "reactor-kotlin-extensions", version = "1.0.2.RELEASE")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-reactor")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-jdk8")
    implementation(group = "org.reflections", name = "reflections", version = "0.9.12")

    // Other dependencies
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin")
    implementation(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jsr310")


    // Test dependencies
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}