package com.learning.basics.strings;

public class StringBasics {
	
	public static void main(String[] args){
		/*
		 * Basically, string is a sequence of characters but it’s not a primitive type.
		 * When we create a string in java, it actually creates an object of type String.
		 * String is immutable object which means that it cannot be changed once it is created.
		 * String is the only class where operator overloading is supported in java. We can concat two strings using + operator. For example "a"+"b"="ab".
		 * Java provides two useful classes for String manipulation – StringBuffer and StringBuilder.
		 */
		
		/*
		 * Different ways to create a string
		 */
		String s = "abc";
		/*When we create a String using double quotes, JVM looks in the String pool to find if any other String is stored with same value.
		 * If found, it just returns the reference to that String object else it creates a new String object with given value and stores it in the String pool.
		 */
		
		/*
		 * Using the New Keyword
		 * 
		 * We can create String object using new operator, 
		 * just like any normal java class. There are several constructors available in String class to get String from char array, byte array, StringBuffer and StringBuilder.
		 */
		
		String s1 = new String("abc");
		char[] a = {'a', 'b', 'c'};
		String s2  =  new String(a);
		
		/*
		 * What is a String Pool Example:::
		 * String Pool in java is a pool of Strings stored in Java Heap Memory.
		 */
		
		/*str1 and str2 both refer to same location in java heap
		 * 
		 */
		String str1 = "cat";
		String str2 = "cat";
		String str3 = new String("cat");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3); //-- false as it checks reference
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3)); // --true as it always checks the value 
		
		/*
		 * String Pool is possible only because String is immutable in Java and it’s implementation of String interning concept. 
		 * String pool helps in saving a lot of space for Java Runtime although it takes more time to create the String.
		 * 
		 * When we use double quotes to create a String, 
		 * it first looks for String with same value in the String pool,
		 *  if found it just returns the reference else it creates a new String in the pool and then returns the reference.
		 *  
		 *  However using new operator, 
		 *  we force String class to create a new String object in heap space.
		 *  We can use intern() method to put it into the pool or refer to other String object from string pool having same value.
		 */
		
		/*
		 * Java String compare
		 * String class provides equals() and equalsIgnoreCase() methods to compare two strings. 
		 * These methods compare the value of string to check if two strings are equal or not. 
		 * It returns true if two strings are equal and false if not.
		 * 
		 * 
		 * String class implements Comparable interface, which provides compareTo() and compareToIgnoreCase() methods and it compares two strings lexicographically.
		 * 
		 * Both strings are converted into Unicode value for comparison and returns integer value which can be greater than, less than or equal to zero. 
		 * If strings are equal then it returns zero or else it returns either greater or less than zero.
		 */
		
		String a1 = "abc";
		String a2 = "abc";
		String a3 = "def";
		String a4 = "ABC";
		
		System.out.println(a1.compareTo(a2));//0
		System.out.println(a2.compareTo(a3));//less than 0
		System.out.println(a1.compareTo(a4));//greater than 0
		System.out.println(a1.compareToIgnoreCase(a4));//0
		
		/*
		 * Java String methods
		 * 
		 * 1.split()
		 * split(String regex): This method splits the string using given regex expression and returns array of string.
		 * split(String regex, int limit): This method splits the string using given regex expression and return array of string 
		 * but the element of array is limited by the specified limit. If the specified limit is 2 then the method return an array of size 2.
		 */
		String s11 = "a/b/c/d";
		String[] a111 = s11.split("/");
		System.out.println("split string using only regex:");
		for (String string : a111) {
			System.out.println(string);
		}
		System.out.println("split string using regex with limit:");
		String[] a21 = s11.split("/", 2);
		for (String string : a21) {
			System.out.println(string);
		}
		
		/*
		 * 2.contains(charSequence c)
		 * Java String contains() methods checks if string contains specified sequence of character or not. 
		 * This method returns true if string contains specified sequence of character, else returns false.
		 * 
		 * 3.length()
		 */
		String s12 = "Hello World";
		System.out.println(s12.contains("Hello"));
		System.out.println(s12.contains("XXX"));
		
		/*
		 * 4.replace() -replace() method is used to replace a specific part of string with other string. 
		 * replace(char oldChar, char newChar): This method replace all the occurrence of oldChar with newChar in string.
		 * replace(CharSequence target, CharSequence replacement): This method replace each target literals with replacement literals in string.
		 * replaceAll(String regex, String replacement): This method replace all the occurrence of substring matches with specified regex with specified replacement in string.
		 * replaceFirst(String regex, String replacement): This method replace first occurrence of substring that matches with specified regex with specified replacement in string.
		 */
		
		//replace(char oldChar,  char newChar)
		String s32 = "Hello World";
		s32 = s32.replace('l', 'm');
		System.out.println("After Replacing l with m :");
		System.out.println(s32);
		
		//replaceAll(String regex, String replacement)
		String s143 = "Hello journaldev, Hello pankaj";
		s143 = s143.replaceAll("Hello", "Hi");
		System.out.println("After Replacing :");
		System.out.println(s143);
		
		//replaceFirst(String regex, String replacement) 
		String s212 = "Hello guys, Hello world";
		s212 = s212.replaceFirst("Hello", "Hi");
		System.out.println("After Replacing :");
		System.out.println(s212);
		
		/*
		 * 5.format()
		 * Java String format() method is used to format the string. There is two variants of java String format() method.
		 * format(Locale l, String format, Object… args): This method formats the string using specified locale, string format and arguments.
		 * format(String format, Object… args): This method formats the string using specified string format and arguments.
		 */
		String sf = "journaldev.com";
		// %s is used to append the string
		System.out.println(String.format("This is %s", sf));
		
		/*
		 * 6.substring()
		 * This method returns a part of the string based on specified indexes.
		 */
		String ss = "This is journaldev.com";
		ss = ss.substring(8,18);
		System.out.println(ss);
		
		/*
		 * 7.String concatenation
		 *  use + operator and concat()
		 */
		
		
		/*
		 * 8.String intern()
		 * When we creates a string using string literal, it will be created in string pool but
		 * what if we create a string using new keyword with same value that exists in string pool? Can we move the String from heap memory to string pool?
		 * 
		 * For this intern() method is used and it return canonical representation of string object.
		 * When we call intern() method on string object that is created using new keyword, it checks if there is already a String with same value in pool?
		 * If yes, then it returns the reference of that String object from pool. If not, then it creates a new String with the same content in the pool and returns the reference.
		 * 
		 */
		
		String s10 = "pankaj";
		String s20 = "pankaj";
		String s30 = new String("pankaj");
		
		System.out.println(s10==s20);//true
		System.out.println(s20==s30);//false
		
		String s40 = s30.intern();
		System.out.println(s10==s40);//true
		
		/*
		 * ::::::::::why is String Immutable in Java???:::::::::
		 * 
		 * String Constant Pool, hence saves memory.
		 * Security as it’s can’t be changed.
		 * Thread safe
		 * Class Loading security
		 */
}

}
