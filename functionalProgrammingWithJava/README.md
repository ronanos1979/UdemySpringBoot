# functionalProgrammingWithJava
Functional Programming with Java from the UDemy course


## Notes from course

Lambda functions streams filters were all introduced in Java 8

Need to have a Paradigm shift. Change how you think about problems to use these new features


### Lambda Expressions
something -> something * somethingelse;


### Stream example
Something.stream()
	.filter ( some -> some condition)
	.map ( some -> some change )
	.forEach ( do something eg sysout )

### Optional
Optional was added to Java 8 to fix problems with Null Pointer Exceptions

		Optional<String> someFruit = Optional.of("strawberry");
		Optional<String> empty = Optional.empty();
		Optional<String> optional2 = fruits2.stream().filter(predicate2).findFirst();
		System.out.println(optional2);
		System.out.println(optional2.isEmpty());
		System.out.println(optional2.isPresent());
		System.out.println(optional2.get()); // throw an exception
		

### Method Reference
Method  References on static methods
Class::Method
e.g.
System.out::println

### Predicates
Predicate functions are functions that return a single TRUE or FALSE . You use predicate functions to check if your input meets some condition. For example, is. character() is a predicate function that returns TRUE if its input is of type character and FALSE otherwise.

## Learn More
	1. Embrace Challenges
	2. Learn from Feedback
	3. Celebrate Effort
	4. Stay curious