import io.quarkus.gradle.tasks.QuarkusNative

plugins {
    kotlin("jvm")
    id("io.quarkus")
    id("org.jetbrains.kotlin.plugin.allopen")
}

group = "br.com.jccf.application"

repositories {
    mavenCentral()
}

val quarkusPlatformGroupId: String by ext
val quarkusPlatformArtifactId: String by ext
val quarkusPlatformVersion: String by ext
val postgresVersion: String by ext
val springJdbcVersion: String by ext
val loggingVersion: String by ext

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":project-core"))
    implementation(project(":project-infrastructure"))

    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-vertx")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jsonb")
    implementation("io.quarkus:quarkus-agroal")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-flyway")

    implementation("org.springframework:spring-jdbc:$springJdbcVersion")
    implementation("commons-logging:commons-logging:$loggingVersion")

    runtimeOnly("org.postgresql:postgresql:$postgresVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
    named<QuarkusNative>("buildNative") {
        isEnableHttpUrlHandler = true
    }
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}
