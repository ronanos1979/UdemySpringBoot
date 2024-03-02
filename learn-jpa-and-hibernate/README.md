##

## H2
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb


Access through console:
http://localhost:8080/h2-console

## Summary

### JDBC
Lots of SQL and Lots of Java

### Spring JDBC
Lots of SQL but less JAVA

###Jpa
Map entities to tables in DB.
Much less code.
Abstracts SQL and don´t really need to know about SQL.

### Spring Data JPA
Define entities. do not need entity manager etc.
Just create an interface...

### Hibernate vs JPA
JPA is an API. It defines the specification.
Application => Spring Data JPA => JPA => Database
JPA defines how you can map 
Hibernate is most popular implementation of JPA.
Use hibernate annotations.

Always use JPA. You can use Hibernate as implementation of JPA.


