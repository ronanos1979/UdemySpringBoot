package com.ronanos.programming.courses.fp01;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,4,3,2,1,12,14,5,2);
		System.out.println("Print all numbers in List");
		printAllNumbersInListStructured(numbers);
		System.out.println(" ");
		System.out.println("Print even numbers in list");
		printEvenNumbersInListStructured(numbers);

	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// enhanced loop
		for (int number: numbers) {
			System.out.println(number);
		}
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		for (int number: numbers) {
			if (number%2==0)
				System.out.println(number);
		}
	}
}
