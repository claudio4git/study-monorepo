# Spring 5.0 and Spring Boot 2.0

Based on:

- https://www.linkedin.com/learning/spring-5-0-and-spring-boot-2-0-new-features (11/2018)
- `spring-boot-2.0-essencial` project

## Core changes

- Tomcat 8.5 > 9 supported
- Flyway 5 database migrations
- Hibernate 5.2 ORM(JPA)
- Thymeleaf 3 HTML view template

Spring 5.1

- Java 1.8 minimum
- Full support for JDK 9 runtime and compilation

Java EE/Jakarta EE

- Java EE 1.7 API required
- Java EE 1.8 API runtime support

Spring 5.1

- Support JDK 11
- GraalVM native image constraints
- Reactor core 3.2 support

## Web changes

- Full support for servlet 3.1
- PushBuilder from HTTP 2.0 push resources
- HTTP/2 support
- Immutable objects (use lombok)
- JSON and Protobuf
- ExceptionHandler, ResponseStatusException, @ResponseStatus, @RestController
- Reactive spring
    - WebClient comparable to RestTemplate
    - Functional and reactive API for HTTP calls
    - Non-blocking and streaming
    - Undertow and Netty support (comparable to Tomcat)
    - WebFlux.fn functional model as alternative to @Controller

## Test changes

- JUnit 5 support in Spring TestContext
- @RunWith removed
- @ExtendsWith supported instead of
- SpringJUnitConfig
- SpringJUnitWebConfig
- @EnabledIf and @DisableIf (EpEL conditionals)
- Parallel test execution
    - JUnit 5, Jupiter 5.2
    - @AutoConfigureMockMvc, MockMvc

## Property changes

- @ConfigurationProperty
- Binding properties

## Actuator

- Major changes in 1.x to 2.x
- URL restructuring
- HAL support
- Custom endpoints
- Security

## Micrometer

- Metrics instrumentation library
- Prometheus, Datadog, Influx
- Auto-configure