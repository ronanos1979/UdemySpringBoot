##

## Learn Maven

### Actions
Create spring project learn-maven on spring initializer website 

```
https://start.spring.io/
```

Add the dependency for spring boot mvc to the pom.xml

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc</artifactId>
			<scope>test</scope>
		</dependency>
```


### Concepts

#### Project Object Model pom.xml

### Dependencies

Spring Boot starter test brings in the dependencies for unit tests. e.g. JUnit and Mockito.

### Build Lifecycle

- validate
- compile
- test (Run unit tests)
- package
- verify -> install -> deploy


### Various Notes

- maven install target: Install stores the artifact to the local repository. This is useful for sharing with other projects.
- help:effective-pom can use this as a target which creates a large pom file 
- In eclipse command click or ctrl click to other dependnecies in pom.

### Starter Dependencies

- spring-boot-starter-webmvc -> good starter as it has all web dependencies
- spring-boot-starter-parent -> Manages versions for you! This is useful for common libraries.

### Spring Boot Maven Plugin
Target to run:

```
spring-boot:run 
```

Also for creating a container image

```
spring-boot:build-image
```


