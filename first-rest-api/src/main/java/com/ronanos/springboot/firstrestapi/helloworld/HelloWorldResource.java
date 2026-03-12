package com.ronanos.springboot.firstrestapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldResource {
	// /hello-world => "Hello World"
	
	@RequestMapping("/hello-world")
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

}
