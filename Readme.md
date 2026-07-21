# SpringBoot Lessons

## Day 1
1. Creating a Maven Project
2. Creating a Gradle Project
3. Creating a Console Application

## Day 2
1. Foundations and 4 Pillars of OOPS (Inheritance, Abstraction, Polymorphism, Encapsulation)
2. Implemented real world examples to realize OOPS Concepts.

## Day 3
1. Implemented GET, FILTER endpoints
2. Learnt collections (SET, HASHSET, LIST, ARRAYLIST)

## DAY 4
1. Best Practices
2. Lambda Functions
3. Interfaces
4. Implementing Services
5. Changing Server Port
6. removeIf, map, reduce, filter, foreach

## DAY 5
1. try, catch, finally
2. Exception Handling
3. Checked and Unchecked Exceptions
4. Building Custom Exception
5. Implementing @ControllerAdvice for GlobalExceptionHandler

## Day 6
1. Dependency Injection
2. Constructor Injection
3. @Primary
4. @Qualifier

## Day 7
1. Configurations and Profiles
2. Dependency Injection Handson
3. @Profile
4. ./mvnw spring-boot:run -<args>
5. Setting active profile in application.properties
6. Working with multiple application-{profile}.properties

## Day 8
1. Adding dependencies in pom.xml
   1. spring-boot-starter-data-jpa
   2. sqlite-jdbc
   3. hibernate-community-dialects
2. Creating Entity with @Entity
3. Adding Database configuration in application.properties

````
spring.datasource.url=jdbc:sqlite:app.db
spring.datasource.driver-class-name=org.sqlite.JDBC

# Hibernate / JPA settings
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````
4. Creating Repository
5. Injecting Repository in Controller
