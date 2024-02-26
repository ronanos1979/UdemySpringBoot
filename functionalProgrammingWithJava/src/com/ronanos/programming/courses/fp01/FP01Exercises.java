package com.ronanos.programming.courses.fp01;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {
		System.out.println("Exercise 1");
		List<Integer> numbers = List.of(12,9,4,3,2,1,12,14,5,2);
		printOddNumbersInListFunctional(numbers);
		System.out.println(" ");
		
		System.out.println("Exercise 2");
		List <String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		courses.stream()
			.forEach(System.out::println);
		System.out.println(" ");
		
		System.out.println("Exercise 3");		
		courses.stream()
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
		System.out.println(" ");
		 
		System.out.println("Exercise 4");		
		courses.stream()
			.filter(course -> course.length() >= 4)
			.forEach(System.out::println);
		System.out.println(" ");
		
		System.out.println("Exercise 5");		
		numbers.stream()			
			.map(number-> number * number * number)
			.forEach(System.out::println);
		System.out.println(" ");
		
		System.out.println("Exercise 6");		
		courses.stream()
			.map(course->course + " " + course.length())
			.forEach(System.out::println);
		System.out.println(" ");
				
	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number%2!=0) // lambda
			.forEach(System.out::println);
	}
}
