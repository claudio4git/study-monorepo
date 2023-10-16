# Spring Framework Basis

## Running with Java Command

Run Java Jar file:

```shell
./mvnw clean package
java -jar -Dspring.profiles.active=sandbox target/initial-boot-app-0.0.1-SNAPSHOT.jar
```

## Running JAR file

- Fat JAR
- Executable
- init.d or systemd

Run the project using maven:

`./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=sandbox"`

## Autoconfiguration

- `@EnableAutoConfiguration`
    - Allows for configuration classes to be scanned dynamically
- Driven off of `spring.factories`
- Control order using `@AutoConfigurateBefore` and `@AutoConfigureAfter`

Example of autoconfigure classes:

- `org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration`
- `org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration`

## Conditional Loading

- `@Conditional`
- `@ConditionalOnClass`
- `@ConditionalOnBean`
- `@ConditionalOnProperty`
- `@ConditionalOnMissing<Class|Bean|Property>`

## Properties

- `@EnableConfigurationProperties` this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
    - Preconfigured "default" on `@EnableAutoConfiguration`
- `application.properties` or `application.yml` file
- Can use Environment variables to override Spring Properties
- `@Configuration` this marks the class as a source of Bean definitions
- `@ConfigurationProperties` this binds and validates the external configurations to a configuration class

## Configurations

- Property-based configuration
    - Basic configuration using `application.properties`
    - Environment variables
    - Command-line parameters
    - Cloud configurations
- Bean configuration
    - Using `@Configuration` to create a Bean class configuration
    - XML-based configuration (legacy)
    - Component scanning

## Profiles

- Flex configuration based on environment profile
- Dev, Prod, Test are examples of profiles
- Profile in the file using `spring.config.activate.on-profile`
- Profile splited in files
    - `application-dev.properties`
    - `application-prod.properties`
- `spring.profiles.active` to engaging a profile vi command line or environment

## Embedded servlet

- Spring Boot provide TomCat by default
- Create or change: Servlets, Filters, and Listeners https://www.baeldung.com/spring-servletcomponentscan
- Create additional `ServletContext` using `ServletContextInitializer` interface
- Customize using properties `org.springframework.boot.autoconfigure.web.ServerProperties`
- Customize compression `server.compression.enable=true`
- Support to SSL

Create a Key to SSL:

```shell
keytool -genseckey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -keysize 2048
keytool -genseckey -keyalg AES -alias linkedin -keystore keystore.jks -storepass password -keysize 128
keytool -genseckey -keystore linkedin.pf12 -deststoretype pkcs12 -keyalg AES -keysize 256 -storepass password -keypass password -noprompt
```

## XML Marshall

Add this dependency to woth with XML responses:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

This commando to get XML responses:

```shell
http http://localhost/api/rooms

http http://localhost/api/rooms Accept:application/xml

curl --location --request GET 'http://localhost:8080/api/rooms' \
--header 'Accept: application/xml'
```

## Devtools

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

Then go to: Intellij IDEA -> Settings -> Build, Execution, Deployment -> Compiler -> Turn on: Build project automatically

Finally, go to: Intellij IDEA -> Settings -> Advanced Settings -> Turn on: Allow auto-make srtart even if developed
application is currently running

## Logging

- SLF4J
- Property-based modifications
- Logback logging

## Actuator

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Endpoints:

- http://localhost:8080/actuator
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/env (authenticated)

Interface to create custom endpoints: `Endpoint`

## Docker

- Build plugins
    - `spring-boot:build-image` for Maven
    - `bootBuildImage` fro Gradle
- Dockerfile example
```
FROM maven:3.8.5-openjdk-17-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src

RUN mvn clean package
COPY target/booting-web-${VERSION}.jar target/application.jar

FROM openjdk:17-jdk-slim-buster
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar
```
- Docker build command `docker build -t booting-web .`
- Docker run command `docker run -p 9090:9090 -d booting-web`

## Boot Starters Customized

- Common code
- Common configuration
- Improve ease of use

Based: https://www.baeldung.com/spring-boot-starters
