package com.learning.basics.strings;

public class StringToCharVc {

	public static void main(String[] args) {
		String str = "journaldev";
		
		//string to char array
		char[] chars = str.toCharArray();
		System.out.println(chars.length);
		
		//char at specific index
		char c = str.charAt(2);
		System.out.println(c);
		
		//Copy string characters to char array
		char[] chars1 = new char[7];
		str.getChars(0, 7, chars1, 0);
		System.out.println(chars1);
	}

}
