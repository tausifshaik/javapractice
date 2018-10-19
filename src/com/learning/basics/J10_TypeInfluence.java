package com.learning.basics;

public class J10_TypeInfluence {

	// With Java 10, you can use var for local variables instead of a typed name (Manifest Type).
	// This is done by a new feature which is called Local Variable Type Inference.
	
	var list = new ArrayList<String>();
	var stream = list.stream();
	
	List<Actors> actors = List.of(new Actor()); // pre java 10
	
	var actors = List.of(new Actor());
	//Parsing a var statement, the compiler looks at the right hand side of the declaration,
	//aka initializer, and it infers the type from the right hand side (RHS) expression.
	
	private static void readFile() throws IOException {
		var fileName = "Sample.txt";
		var line = "";
		var fileReader = new FileReader(fileName);
		var bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();
	}
	
	//var is not a keyword, It’s a reserved type name. 
	
	var var = 5; //correct
	
	public static void var(){
		
	} // correct
	
	package var //correct
	
	class var{
		//compiler error
		
	}
	interface var{
		//compiler error
	}
	
	//Local type inference can be used only in the following scenarios:

		//Limited only to Local Variable with initializer
		//Indexes of enhanced for loop or indexes
		//Local declared in for loop
	
	var numbers = List.of(1, 2, 3, 4, 5); // inferred value ArrayList<String>
	// Index of Enhanced For Loop
	for (var number : numbers) {
		System.out.println(number);
	}
	// Local variable declared in a loop
	for (var i = 0; i < numbers.size(); i++) {
		System.out.println(numbers.get(i));
	}
	
	var x; // cannot with out initializer
	
	var x=5,y=10; // cannot do compound initialization
	
	var author = null;//null cannot be used as a initializer
	
	
}
