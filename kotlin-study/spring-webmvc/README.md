# About

Study repo for kotlin and Spring.

## Product

- CRUDL clients
- CRUDL orders
- CRUDL products

The client can create orders with one or more products.

## Technologies

- Kotlin
- Spring core
- Spring boot
- Spring webmvc
- Spring data
  - https://spring.io/guides/tutorials/spring-boot-kotlin/
  - https://www.baeldung.com/java-hibernate-uuid-primary-key
- [H2](https://www.baeldung.com/spring-boot-h2-database)
- [Flyway](https://www.baeldung.com/database-migrations-with-flyway)

## To do

- Spring JDBC API
- Spring data JDBC
- PostgreSQL
- MongoDB

## Flyway command

```shell
$ mvn -Dflyway.url=url -Dflyway.user=user -Dflyway.password=pass -Dflyway.schemas=schema
```
