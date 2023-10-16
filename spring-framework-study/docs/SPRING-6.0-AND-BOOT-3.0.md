# Spring 6.0 and Spring Boot 3.0

Based on https://www.linkedin.com/learning/spring-6-and-spring-boot-3-first-look (11/2022)

## Baseline versions

- New baseline Java 17
- Jakarta EE 9
- Kotlin 1.9
- Spring boot 3.x requires Spring 6.x
- Gradle requires 7.3

## Jakarta EE

- EhCache 2 removed
- EhCache 3 removed (possibly temporary)
- Hazelcast 3/5 supported
- Apache ActiveMQ removed
- Atomikos removed
- Apache Johnson removed

## Configurations

- Actuator and Metrics
- Micrometer auto-configuration
- Spring data have Beans required now is conditional
- `spring.factories` is no longer supported, use `AutoConfiguration.imports` file

## Native images

- Less disk space needed
- More efficient memory utilization
- More efficient CPU processing
- Faster startup
- Fewer dependencies
- GraalVM
- No longer lazy loaded
- Changes Spring's functionality in a native image
- profile and ConditionalOnProperty not supported
- Reflection don't work on native images

## Observability

- Micrometer
    - Spring cloud sleuth not supported
    - Micrometer tracing supported
    - Log correlation
    - W3C context propagation supported
- Remote baggage

## Callouts

Web:

- URL matching no longer support the trailing slash as the base method
- HttpMethod is now a class, before were an Enumeration
- Servlet is now in `jakarta.servlet` instead of `javax`

Data:

- Data from `javax.persistence` to `jakarta.persistence`
- Validation from `javax.validation` to `jakarta.validation`
- elastic now leverages Java client

Security:

- WeSecurityConfigurerAdapter removed
- MvcRequestMatcher by default instead of WeSecurityConfigurerAdapter
