package com.learning.basics.strings;

public class StringInteverviewQs {

	public static void main(String[] args) {

		/*
		 * 1. What is String in Java? String is a data type?
		 * String is a class in java defined in java.lang package.It’s not a primitive data type like int and long.
		 * String in immutable and final in Java and JVM uses String Pool to store all the String objects.
		 * 
		 * 2. Write a method to check if input String is Palindrome?
		 * 
		 * A String is said to be Palindrome if it’s value is same when reversed. For example “aba” is a Palindrome String.
		 * String class doesn’t provide any method to reverse the String but StringBuffer and StringBuilder class has reverse method that we can use to check if String is palindrome or not.
		 * 
		 */
		
		String s ="aba";
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		System.out.println("string 'aba' is palindrome ::: "+ sb.toString().equals(s));
		
		/*
		 * Recursive method to find if a string is palindrome or not
		 * 		 
		 */
		StringInteverviewQs intqs = new StringInteverviewQs();
		boolean isPalindrome = intqs.isPalindrome("liril");
		System.out.println("string 'liril' is palindrome ::: "+ isPalindrome);
		
		/*
		 * 3.String Subsequence
		 */
		String str = "www.journaldev.com";
		System.out.println("Last 4 char String: " + str.subSequence(str.length() - 4, str.length()));
		System.out.println("First 4 char String: " + str.subSequence(0, 4));
		System.out.println("website name: " + str.subSequence(4, 14));
		// substring vs subSequence
		System.out.println("substring == subSequence ? " + (str.substring(4, 14) == str.subSequence(4, 14)));
		System.out.println("substring equals subSequence ? " + (str.substring(4, 14).equals(str.subSequence(4, 14))));
		
		/*
		 * 4. compareTo() & compareToIgnoreCase() vs equals() & equalsIgnoreCase()
		 */
		
		/*
		 * 5.Can we use String in switch case?
		 * This is a tricky question used to check your knowledge of current Java developments.
		 *  Java 7 extended the capability of switch case to use Strings also, earlier java versions doesn’t support this.
		 *  If you are implementing conditional flow for Strings, you can use if-else conditions and you can use switch case if you are using Java 7 or higher versions.
		 */
		/* check output of the below snippets
		 * 
		 */
		String sr1 = new String("abc");
		String sr2 = new String("abc");
		System.out.println(sr1 == sr2); //false because we are using new operator to create String, so it will be created in the heap memory and both s1, s2 will have different reference.
		
		String sb1 = "abc";
		StringBuffer sb2 = new StringBuffer(sb1);
		System.out.println(sb1.equals(sb2)); //It will print false because s2 is not of type String. If you will look at the equals method implementation in the String class,
											//	you will find a check using instanceof operator to check if the type of passed object is String? If not, then return false.
		
		
		String si1 = "abc";
		String si2 = new String("abc");
		si2.intern();
		System.out.println(si1 ==si2); //false, change above line to si2 = si2.intern(); the result wil be false
		
		String so1 = new String("Hello");  
		String so2 = new String("Hello");
		/*
		 * 3 objects gets created.
		 * First – line 1, “Hello” object in the string pool.
		 * Second – line 1, new String with value “Hello” in the heap memory.
		 * Third – line 2, new String with value “Hello” in the heap memory. Here “Hello” string from string pool is reused.
		 */
	}
	private static boolean isPalindrome(String str){
		int length = str.length();
		if(length < 2) return true;
		else return str.charAt(0) != str.charAt(length - 1) ? false :
			isPalindrome(str.substring(1, length - 1));
	}
	
	
	/*
	 * Why String is popular HashMap key in Java?
	 * Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. 
	 * This makes it a great candidate for key in a Map and it’s processing is fast than other HashMap key objects. This is why String is mostly used Object as HashMap keys.
	 */

	
	

}
