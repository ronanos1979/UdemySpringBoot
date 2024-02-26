package com.ronanos.programming.courses.fp01;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,4,3,2,1,12,14,5,2);
		printAllNumbersInListFunctional(numbers);
		System.out.println(" ");
		printEvenNumbersInListFunctional(numbers);
		System.out.println(" ");
		printSquaresOfEvenNumbersInListFunctional(numbers);

		
	}

	// Made simpler by calling directly 
	//	private static void print(int number) {
	//		System.out.println(number);
	//	}

	// Replaced with lambda
	//	private static Boolean isEven(int number) {
	//		return number%2==0;
	//	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// Stream which is sequence of elements
		numbers.stream()
		// .forEach(FP01Functional::print);  // Method Reference
		.forEach(System.out::println); // Method Reference
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Functional::isEven)
		.filter(number -> number%2==0) // lambda
		.forEach(System.out::println);
	}
	
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Functional::isEven)
			.filter(number -> number%2==0) // lambda
			.map(number -> number * number)
			.forEach(System.out::println);
	}

}