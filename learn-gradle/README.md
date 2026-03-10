# Learn Gradle

## Gradle Information

### Summary

Ant did not take care of dependencies etc.
Ant provides structure

Maven provides flexibility. It is simple familiar and restrictive
Maven defines
    Folder Structure
    Build XML

Gradle gives structure of ant and functionality of Maven. Also the performance is improved.
Gradle provides faster builds, less verbose configuraiton.

Can use groovy or kotlin.
Gradle provides high performance.
It only rebuilds what changed. It provides incremental builds. It 
Gradle inherits project layout from Maven.



| Feature | Maven | Gradle |
| -------- | -------- | -------- |
| Configuration | XML (Declarative) | Groovy/Kotlin (Programmable) |
| Flexibility | Low (Strict Standards) | High (Do anything) |
| Performance | Good | Excellent (Incremental, Cache) |
| Learning Curve | Easy (Standard) | Steeper (need to learn Domain Specific Language (DSL) |
| Use Case | Standard Java Projects | Android, Complex Builds, Monorepos |

Need to understand Groovy Kotlin to use Gradle.


### Configuration
settings.gradle.
repositories -> Use the Maven Central Repository

### Notes
testRuntimeOnly If you want to run JUnit platform launcher to run JUnit tests.

### Plugins
Defined in build.gradle file.

#### Java Plugin
	Adds tasks e.g. 
	- test 
	- jar 
	- compileJava
	
#### Spring Boot Plugin
	Adds tasks e.g.
	- bootRun
	- bootJar
	- bootBuildImage
	
#### Dependency Management Plugin
Similar to Maven dependency management.
	To import similar to maven e.g.
		org.springframwork:spring-core:10.0.3
		
### Gradle Tasks

		
		
		

