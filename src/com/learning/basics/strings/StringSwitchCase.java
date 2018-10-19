package com.learning.basics.strings;

public class StringSwitchCase {

	public static void main(String[] args) {
		
		/*
		 * 5.Can we use String in switch case?
		 * This is a tricky question used to check your knowledge of current Java developments.
		 * Java 7 extended the capability of switch case to use Strings also, earlier java versions doesn’t support this.
		 * If you are implementing conditional flow for Strings, you can use if-else conditions and you can use switch case if you are using Java 7 or higher versions.
		 */
		
		printColorUsingSwitch("red");
		printColorUsingIf("red");
		// switch case string is case sensitive
		printColorUsingSwitch("RED");
		printColorUsingSwitch(null); //-- NULL POINTER EXCEPTION
		
		/*
		 * Java switch case String make code more readable by removing the multiple if-else-if chained conditions.
		 * Java switch case String is case sensitive, the output of example confirms it.
		 * Java Switch case uses String.equals() method to compare the passed value with case values, so make sure to add a NULL check to avoid NullPointerException.
		 * According to Java 7 documentation for Strings in Switch, java compiler generates more efficient byte code for String in Switch statement than chained if-else-if statements.
		 * Make sure to use java switch case String only when you know that it will be used with Java 7 else it will throw Exception.
		 */

	}
	
	private static void printColorUsingIf(String color) {
		if (color.equals("blue")) {
			System.out.println("BLUE");
		} else if (color.equals("red")) {
			System.out.println("RED");
		} else {
			System.out.println("INVALID COLOR CODE");
		}
	}
	
	private static void printColorUsingSwitch(String color) {
		if(color != null){
			switch (color) {
			case "blue":
				System.out.println("BLUE");
				break;
			case "red":
				System.out.println("RED");
				break;
			default:
				System.out.println("INVALID COLOR CODE");
			}
		}
		
	}

}
