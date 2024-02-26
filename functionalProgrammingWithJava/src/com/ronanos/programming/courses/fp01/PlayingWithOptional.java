package com.ronanos.programming.courses.fp01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruits = List.of("apple", "banana", "mango");
		List<String> fruits2 = Arrays.asList("apple", "banana", "mango");
		
		Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
		Optional<String> optional = fruits.stream().filter(predicate).findFirst();
		System.out.println(optional);
		System.out.println(optional.isEmpty());
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		
		System.out.println(" ");
		
		Predicate<? super String> predicate2 = fruit2 -> fruit2.startsWith("z");
		Optional<String> optional2 = fruits2.stream().filter(predicate2).findFirst();
		System.out.println(optional2);
		System.out.println(optional2.isEmpty());
		System.out.println(optional2.isPresent());
		System.out.println(optional2.get());
		
		Optional<String> someFruit = Optional.of("strawberry");
		Optional<String> empty = Optional.empty();
	}

}
