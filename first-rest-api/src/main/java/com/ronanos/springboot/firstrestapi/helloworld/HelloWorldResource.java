package com.ronanos.springboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller // If using this need to have @REsponseBody added to each endpoint
// Using @Controller for providing a View e.g. for JSP or something like that.
// For an API just use @RestController.
@RestController  // Using @RestController means I do not need to have @ResponseBody below.
public class HelloWorldResource {
	// /hello-world => "Hello World"
	
	@RequestMapping("/hello-world")
	// @ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	// Path Variables or Path Params
	// /user/someusername/todos/1
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World, " + name);
	}
	
	// http://localhost:8080/hello-world-path-param/ronan/message/hello
	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name,
														@PathVariable String message) {
		return new HelloWorldBean("Hello World, " + name + "," + message);
	}
}
