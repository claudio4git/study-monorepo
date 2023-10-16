# Spring Framework Modules

## Web MVC

Engine Template Controller class example:

```java
@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repository;
    // constructor omitted
    
    public String getUserPage(Model model) {
        List<Users> users = repository.finAll();
        model.addAttribute("users", users);
        return "users"; // HTML template
    }
}
```

WS/Restful endpoint Controller class example:

```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repository;
    // constructor omitted
    
    @GetMapping
    public List<Users> getUserPage() {
        return  repository.finAll(); // JSON raw data
    }
}
```

## Repository and Database

- Spring data
    - RDBMS and NoSQL database support
- Spring JDBC
- RepositoryRestResources

Dependency:

```xml
<depencencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
  </dependency>
  <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId> <!-- embedded database -->
      <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId> <!-- real database -->
  </dependency>
</depencencies>
```

Properties:

```text
# embedded database
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:db
spring.jpa.hibernate.ddl-auto=none
# real database
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database=postgresql
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

H2 console for embedded database

- http://localhost:8080/h2-console

Table example:

```java
@Entity
@table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @column(name="ID")
    private Long id;

    @column(name="NAME")
    private String name;
    
    // Gets and Sets omitted
}
```

Repository example:

```java
@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
```

Application listener example:

```java
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository repository;
    
    public AppStartupEvent(UserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.repository.findAll();
    }
}
```

## Security

- Authentication and Authorization
- `WebConfigurerAdapter`
- @EnableWebSecurity
- @EnableOAuth2Client
- @EnableAuthorizationServer
- @EnableResourceServer
- Password hashed and not encrypted (SHA-1 in sandbox, BCrypt in production)

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## Asynchronous Messaging

- Producer
- Consumer

Dependency:

```xml
<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-amqp</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
  </dependency>
</dependencies>
```

Or up-to-date way:

```xml
<depencencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId>
  </dependency>
</depencencies>
```

## Command Line Interface

- CommandLineRunner
- ApplicationRunner
- Single-run method
- `@Order` annotation

Dependency:

```xml
<depencencies>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
  </dependency>
</depencencies>
```

Or up-to-date way:

```xml
<depencencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-boot-starter</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
  </dependency>
</depencencies>
```
