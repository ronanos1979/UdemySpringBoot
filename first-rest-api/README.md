# Spring Boot Deep Dive with REST API

## Useful Links

```
https://github.com/in28minutes/spring-boot-master-class/tree/master/05.Spring-Boot-Advanced-V2

https://github.com/in28minutes/spring-boot-master-class/blob/master/05.Spring-Boot-Advanced-V2/99.step-by-step-code-changes.md
```

## REST Representational State Transfer
- Architectural style for web.
- Key abstraction - Resource. Whenever talking about REST we are talking about resources

 	- e.g. todo Management application
 		- Examples: Users, Todos
 	- Resource has URI (Uniform Resource Identifier)
 		- /users/someusername - (/users/{id})
 		- /users/someusername/todos - (/users{id}/todos)
 		- /users/someusername/todos/1 - (/users/{id}/todos/{id})
 	- You can perform ACTIONS on resources
 		- retrieve/add/update/delete todo
 		- retrieve/add/update/delete users
 		
  		
