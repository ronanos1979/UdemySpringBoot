# Learn Gradle

Some text above.

sdaf



| Head1 | Head2 |
| ----- | ----- |
| Data  | Data  |


Some text below.


## Gradle Information

Some text above.


| Header | Header |
| ------ | ------ |
| Cell | Cell |

Some text below.


### Summary

Ant did not take care of dependencies etc.
Ant provides structure


Some text above.


| Header | Header |
| ------ | ------ |
| Cell | Cell |

Some text below.



Maven provides flexibility
Maven defines
    Folder Structure
    Build XML

Gradle gives structure of ant and functionality of Maven. Also the performance is included

Can use groovy or kotlin.
Gradle provides high performance.
It only rebuilds what changed. It provides incremental builds. It 
Gradle inherits project layout from Maven.



| Feature | Maven | Gradle |
| -------- | -------- | -------- |
| Configuration | XML (Declarative) | Groovy/Kotlin (Programmable) |
| Flexibility | Low (Strict Standards) | High (Do anything) |
| Performance | Good | Excelent (Incremental, Cache) |



| Header 1 | Header 2 |
| -------- | -------- |
| Cell A   | Cell B   |
| Cell C   | Cell D   |



| Header 1 | Header 2 | Header 3 |
| :--- | :----: | ---: |
| Left-aligned content | Center-aligned content | Right-aligned content |
| Cell A | Cell B | Cell C |





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

		
		
		

