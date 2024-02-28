# learn-spring-boot
## Notes from UDemy Course

## Spring Boot
	Spring Initializr
	Starter Projects
	Autoconfiguration
	Developer Tools
	Actuator
	
## Before Spring Boot
Needed to manage framework and versions
REST API - Spring Framework, Spring MVC Framework, JSON binding framework
Unit Tests - Spring Test, Mockito, Junit

Configure web.xml. e.g. Configure DispatcherServlet.

Define Spring Configuration
Component Scan
View Resolver
Data Source 

NFRs Non functional requirements
Needed to be implemented.
Logging 
Error Handling
Monitoring

Before Spring Boot needed to do this
	1. Dependency Management (pom.xml)
	2. Define Web App Configuration (web.xml)
	3. Manage Spring Beans (context.xml)
	4. Implement Non Functional Requirements

### Spring Initializr
Website to create spring boot applications

### Spring Boot Starter Projects
Quickly define dependencies for projects.
Convenient Dependency Descriptors

### Spring Boot AutoConfiguration
Define configuration based on dependencies which are in the classpath

### Spring Bot DevTools
Allow you to make changes without needing to restart the server.


## Production Ready
### Logging
Spring Boot Logging

### Configuration for different Environments
Spring Boot provides profiles and configuration properties.

### Monitor Application.
View metrics for application. This is from Spring Boot Actuator

## Starter Projects
### Spring-boot-starter-web 
This enables you to build REST API and web applications

### Spring-boot-starter-test
Helps to write unit tests

### Spring-boot-starter-json
Allows to do bean to JSON and vice versa

### Spring-boot-starter-tomcat
### Spring-boot-starter-jetty
### Spring-boot-starter-undertow

### spring-web and spring-mvc
The MVC framework for the REST API


### JSON Conversion
Conversion from Java List to JSON.


## Spring Boot AutoConfiguration
Decided based on which frameworks are in the classpath.
Based on existing configuration via annotations.
Autoconfiguration is defined in the spring-boot-autoconfigure.jar which is pulled in as a dependency.
Change logging level of application and view the output to see what was autoconfigured in conditions evaluation report.

1. Dispatcher Servlet (DispatcherSErvletAutoConfiguration)
2. Embedded servlet container. Tomcat is the default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
3. Default Error Page (ERrorMvcAutoConfiguration)
4. Bean <-> JSON (JacksonHttpMessageConvertersConfiguration)

## Spring Boot DevTools
Allow hot deploy of tools.

## Spring Boot Actuator
Provides endpoints to view
Access through: http://localhost:8080/actuator
beans
health
metrics
mappings


## Spring Framework is all about dependency injection
Defining dependencies ( through annotations @Component @Autowiredetc. )
Identifying dependencies ( using Component Scan on package )
Autowiring them together.

## Spring Boot
To Talk to a DB need Hibernate and JPA. To write Unit test we need Junit & mockito etc.

Spring Modules and Spring Projects extend the Spring ECO Framework.

## Spring MVC
Spring MVC is a spring module. Simplify building web app and REST API.
Defines @Controller @RestController @RequestMapping("/something")

## Spring Boot
Spring Boot is a Spring Project.
Key feature is starter projects.
e.g. web starter project.
Autoconfiguration removes need to setup springMVC etc.
Spring Boot also enables actuator etc.
Provides default logging and error handling.

## Web Application
1, Web App Concepts ( Browser, HTML, CSS, Request, Response, Form, Session, Authentication)
2. Spring MVC )Dispatcher Servlet, View Resolvers, Model, View, Controller, Validations .. )
3. Spring Boot (Starters, Auto Configuration, .. )
4. Frameworks/Toiols (JSP, JSTL, JPA, Bootstrap, Spring Security, MySQL, H2)

## Github links
https://github.com/in28minutes/spring-boot-master-class/tree/master/02.Spring-Boot-Web-Application-V2

https://github.com/in28minutes/spring-boot-master-class/blob/master/02.Spring-Boot-Web-Application-V2/Step05.md

https://github.com/in28minutes/spring-boot-master-class/blob/master/02.Spring-Boot-Web-Application-V2/99-step-by-step-changes.md#step01





