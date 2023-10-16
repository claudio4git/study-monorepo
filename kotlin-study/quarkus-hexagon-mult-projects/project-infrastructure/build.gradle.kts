plugins {
    kotlin("jvm")
}

group = "br.com.jccf.infrastructure"

repositories {
    mavenCentral()
}

val springJdbcVersion: String by ext
val postgresVersion: String by ext

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":project-core"))

    implementation("org.springframework:spring-jdbc:$springJdbcVersion")

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
}
