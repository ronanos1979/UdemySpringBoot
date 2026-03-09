##

## H2
H2 is an in memory database.
Add the following settings to the application.properties.

```
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
```

Note the JDBC connection string. If you need to get the DB connection string get it from the console of the application.
Access through console:

```
http://localhost:8080/h2-console
```

A sample query for this application is 

```
select * from COURSE
```

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


