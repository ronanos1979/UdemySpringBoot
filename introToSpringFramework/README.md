# Getting Started

# IntroToSpringFramework
Introduction To Spring Framework From UDemy Course

# Notes from Course
## Areas to cover
SOA = Service Oriented Architecture
Tight Coupling Loose Coupling
IOC Container
Application Context
Component Scan
Dependency Injection
Spring Beans
Auto Wiring

## Tightly Coupled
Need to change logic in GameRunner to chose either MarioGame or SuperContraGame to run.

## Loosely Coupled
Abstract with using interfaces

## Spring Terminology
### @Component
A component managed by the Spring Framework

### Dependency
Something needed to create an instance of the class

### Component Scan
Scan of classes which are defined in the @ComponentScan. This could be brought in by the @SpringBootApplication annotation. That would scan the package and sub packages that the class annotated with @SpringBootApplication is in.
@ComponentScan({"com.package1","com.package2"})

### Dependency Injection
Identifying the beans, Identifying the dependency of the beans and wiring them together. It provides IOC

### IOC Inversion of Control
Shifting control from our code to the spring framework

### Spring Beans
An object managed by the spring framework

### IOC Container
Manages the lifecycle of beans and dependencies
Types: ApplicationContext (complex), BeanFactory (simpler but rarely used)

### Autowiring
Process of wiring in dependencies for a specific bean

### Layers of Application
1. Web
2. Business
3. Data
4. Database
Each layer is dependent on layer below it.
Spring Framework allows us to focus on the business layer without focusing on the dependencies and the autowiring.

### Dependencies
Maven dependencies are for jars for the application
Spring dependencies are at a lower level than  Maven Dependencies. They are at the level of a class.

## Depenency Injection Types
### Constructor Based
Dependencies are set by creating the bean using it´s constructor

e.g.

	@Autowired
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {	
		this.game = game;
	}
	
Another method
	
	private DataService dataService;

	@Autowired
	public BusinessService(DataService dataService) {
		super();
		System.out.println("Constructor Injection");
		this.dataService = dataService;
	}
	


### Setter Based
Dependencies are set by calling setter methods on your beans

Note the @Autowired is moved to the setter method not the variable.

	private DataService dataService;

	@Autowired
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}



### Field
No setter or constructor. Dependency is injected using reflection.

Note there is no constructor or setter method.
	@Autowired
	private BusinessService businessService;
	
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
 
### Which type to use
Spring team recommends Constructor based injection. Because dependencies are automatically set when an object is created.

## Spring Modules
Spring Framework modules
Core - this is the IoC container
Testing - Mock Objects, Spring MVC tests etc.
DataAcess - Transactions, JDBC, JPA etc.
WebServlet - Spring MVC etc.
Integration - JMS etc.
WebReactive -  Spring WebFlux etc.

## Spring Projects
Spring Boot
Spring Cloud
Spring Data
Spring Security

### Spring Boot
Most popular for microservice or REST API

### Spring Cloud
For applications that can be deployed natively to the cloud.

### Spring Data
Integrate the same way with different types of databases. NoSQL and Relational.

### Spring Integration
Addresses challenges with integration with other applications

### Spring Security
Secure your web application or RESTAPI or microservice


## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0-M1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0-M1/maven-plugin/reference/html/#build-image)

