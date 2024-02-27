package com.ronanos.spring.introToSpringFramework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ronanos.spring.introToSpringFramework.enterprise.example.business.BusinessService;

@Component
public class MyWebController {
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	public MyWebController(BusinessService businessService) {
		super();
		System.out.println("MyWebController Constructor Injection");
		this.businessService = businessService;
	}

	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}
