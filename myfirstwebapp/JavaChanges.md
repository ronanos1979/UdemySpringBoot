
# Java Framework Updates
Here is a bookmark with lots of this information:

```
https://interview.in28minutes.com/interview-guides/java/new-features-in-java/
```


## Changes introduced in Versions of Java
### Java 5
- Enhanced for loops

```
for (int num: numbers) {;;;}
```

- Generics
Makes it easy to write typesafe code

```
public class Hashmap<K,V> extends AbstractMap<K,V>
```

- Enum

```
enum Season {
	WINTER,SPRING,SUMMER,AUTUMN
}
```

- Autoboxing
Converts primatives to wrapper classes;

```
Integer integer = 5;
int i = integer;
```

### Java SE 7
- Try-With-Resources. In case forget to call br.close. Automatic resource management in try catch blocks.

```
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {}
```

- Strings in Switch 

```
switch (day) {
	case "Monday":
	case "Tuesday":
	default:
}
```

### Java 8
Introduced Functional Programming, Streams and Lambda functions among others.
- Lambda Expressions Allows writing concise, functional-style code

```
public static Predicate <Course>
		createPredicate(int cutoff) {
	return course -> 
			course.getREviewScore() > cutoff;
}
```

- Lambdas and Functional Programming 
Old

```
Collections.sort(list, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});
```

New 

```
list.sort((a, b) -> a.compareTo(b));
```

- Streams API
Streams let you process data declaratively (filter, map, reduce) with less boilerplate.

```
List<String> names = List.of("Bob", "Alice", "Charlie");
names.stream()
     .filter(n -> n.startsWith("A"))
     .forEach(System.out::println);
```

- New Date & Time API (java.time)
Old: 

```
Date now = new Date();
```

New

```
LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusWeeks(1);
```

Provides a powerful way to process collections

```
List<String> transformedNumbers = numbers.stream()
	.map(x -> x * x) // Step 1: Square each number // map is an intermediate operation as it returns a stream
	.map(x -> x + 10) // Step 2: Add 10
	.map(x -> "Value: " + x) // Step 3: Convert
	.toList(); // Collect the result // toList is a terminal operation.
```

- Functional Programming - Introduces higher order functions and immutability

```
courses.stream()
		.sorted((c1, c2) -> c1.length() - c2.length())
		.forEach(System.out.println);
```


### Java 9
- Modularization - Splut JDK into modules for better scalability

Java 9 introduced the module system, letting you break applications into explicit, well‑defined modules.
This improves startup time, security, and maintainability.

```
module com.example.app {
    requires java.sql;
    exports com.example.app.api;
}
```

- Faster startup and reduced memory footprint
Thanks to modularization and JVM improvements, Java 9 can load only the modules your app needs.
This means:

Smaller runtime image

Faster startup

Lower memory usage

```
jlink --module-path $JAVA_HOME/jmods \
      --add-modules java.base,java.sql \
      --output myruntime
```

- JShell The Java REPL An interaction command line tool for testing Java code.

```
jshell> int x = 5;
jshell> x * 2
$1 ==> 10
```

- Improved Streams API

New methods like takeWhile, dropWhile, and iterate enhancements.

```
List<Integer> nums = List.of(1,2,3,0,4,5);
nums.stream()
    .takeWhile(n -> n > 0)
    .forEach(System.out::println); // prints 1,2,3
```

- HTTP/2 Client (Incubator)
❌ Old Way (HttpURLConnection)
Verbose

Hard to configure

Blocking only

No HTTP/2

Awkward API

```
URL url = new URL("https://example.com");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");

try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(conn.getInputStream()))) {

    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
```

New Way (Java 11 HTTP/2 Client)
Modern, fluent API

Supports HTTP/2

Async with CompletableFuture

Cleaner and easier to use

```
HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .build();

HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());

```

### Java 10
6 month release cycle
- Local variable Type Inference (var)
Old: 

```
Map<String, Integer> scores = new HashMap<>();
```

New:

```
var scores = new HashMap<String, Integer>();
```

- Application Class-Data Sharing
- Container Awareness
- Garbage Collector Improvements



### Java 11

- Boilerplate in classes is 
Old
 
```
class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
```

New

```
record Person(String name, int age) {}
```


- Reduced verbosity
- Switch exressions - Concise conditional logic
Old
```
int num = 2;
String result;
switch (num) {
    case 1: result = "one"; break;
    case 2: result = "two"; break;
    default: result = "other";
}
```

New
```
int num = 2;
String result = switch (num) {
    case 1 -> "one";
    case 2 -> "two";
    default -> "other";
};
```

- Text Blocks - Simplifies multiline strings
Old

```
String json = "{\n  \"name\": \"Alice\",\n  \"age\": 30\n}";
```

New

```
String json = """
{
  "name": "Alice",
  "age": 30
}
""";
```

- Records - Reduces boilperplat data objects
Before

```
class Person {
    private final String name;
    private final int age;
    // constructor, getters, equals, hashCode, toString...
}
```

With record 

```
record Person(String name, int age) {}

Person p = new Person("Alice", 30);

```

- Pattern Matching for instanceof - enhances code readability
Before

```
Object obj = "Hello";
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}
```

With pattern matching

```
Object obj = "Hello";
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```
### Java 17
- Sealed Classes - Controlled inheritance for your class hierarchies.

Only allow these 3 classes to extend Vehicle

```
sealed class Vehicle permits Car, Truck, Bike {}

// No further subclassing
final class Car extends Vehicle {}

// Can be extendned freely
non-sealed class Truck extends Vehicke {}

sealed class Bike extends Vehicle
					permits ElectricBike {}
					
// No further subclassing
final class ElectricBike extends Bike {}
```

### Java 21
- Project Loom - virtual threads for high performance concurrency
Java 21 introduces virtual threads, which are extremely lightweight threads managed by the JVM.
They make highly concurrent code (like servers) much simpler and faster without complex async frameworks.
Previuosly there was platform threads. An OS thread was created when a thread was created. Each of them requires memory and then it was limited by the amount of threads an OS could have. The lightweight threads in Java 21 are not limited.


Key idea: You write normal blocking code, but it scales like async.

Example:

```
public class LoomDemo {
    public static void main(String[] args) throws Exception {
        Thread.startVirtualThread(() -> {
            System.out.println("Running in a virtual thread");
        }).join();
    }
}
```

- Sequenced Collections - Add operations for ordered collections.

```
interface SequencedCollection<E> extends Collection<E> {
	void addFirst(E element);
	void addLast(E element);
	E getFirst();
	E getLast();
	E removeFirst();
	SequencedCollection<E> reversed();
}
```

- Record Patterns - Support deconstruction, including nested patterns

```
record Transaction(
	String sender, String receiver, double amount) {}
	
public void processTransaction(Object obj) {
	if (obj instanceof Transaction(
		String sender, String receiver, double amount)) {
			System.out.println("Processing transaction: "
				+ sender + " -> " + receiver + " : " + amount );
		}
}
```

- Pattern Matches for Switch

```
interface CustomerMessage{}
record TextMessage(String text) implements CustomerMessage {}
record Ticket(int ticketNumber) implements CustomerMessage {}

CustomerMessage message = new Ticket(1050);

String response = switch (message) {
	case TextMessage(String text)
			-> "Processing text message: "
				+ text;
	case Ticket(int ticketNumber)
			-> "Processing support ticket: #"
				+ ticketNumber;
};

System.out.println(response);
```

- Cloud Container ready - optimized for cloud native apps


	- Smarter memory limits (respects container cgroups)
	- Faster startup and lower footprint
	- Better performance under constrained CPU/memory
	- Long‑term support (LTS), ideal for production
	
	
### Java 22
- Unnamed Variables & Patterns - Allows ignoring unused variables in code.

``` switch (obj) { // I will not use the value!
	case String _ -> System.out.println("String");
	case Integer _ -> System.out.println("Integer");
	default -> System.out.println("Unknown type.");
}
```

### Java 23
- Markdown Documentation Comments - Enhances Javadoc with Markdown support.

/// This is the **traditional**
/// *Hello World!* program.

/// This is the <strong>tranditional</strong>
/// <em>Hello World!</em> program.

### Java 24
- Stream Gatherers - Introduces new ways to aggregate stream date;

```
// A new way to group,
// transform, and aggregate stream elements
List<List<Integer>> windows = numbers.stream()
	.gather(Gatherers.windowFixedSize(3))
	.toList();
// [1,2,3]
// [4,5,6]
// [7,8,9]
// [10]
```


### Java 25
- Project Loom (Matured) — Virtual Threads Everywhere
By Java 25, virtual threads are expected to be fully integrated and optimized across the platform.
The goal: massively scalable concurrency with simple, blocking code.

What this means:

	- Virtual threads become the default choice for servers and concurrent apps.
	- Improved schedulers and debugging tools.
	- Better integration with structured concurrency.

- Cloud‑Native by Default — Smarter, Leaner, Faster
Java 25 continues the trend of being container‑aware and cloud‑optimized out of the box.

What this means:

	- Better startup and warm‑up times.
	- Improved memory efficiency for microservices.
	- Smarter JIT/AOT combinations for cloud workloads.
	- Enhanced observability hooks (metrics, tracing).
	- Tiny example (simple cloud‑friendly service):
