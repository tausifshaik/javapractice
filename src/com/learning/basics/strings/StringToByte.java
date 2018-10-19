package com.learning.basics.strings;

import java.util.Arrays;

public class StringToByte {

	public static void main(String[] args) {
		String str = "TAUSIF";
		byte[] byteArr = str.getBytes();
		// print the byte[] elements
		System.out.println("String to byte array: " + Arrays.toString(byteArr));
		
		byte[] byteArray = { 'T', 'A', 'U', 'S', 'I', 'F' };
		byte[] byteArray1 = {84, 65, 85, 83, 73, 70 };

		String str11 = new String(byteArray);
		String str1 = new String(byteArray1);

		System.out.println(str);
		System.out.println(str11);

	}

}
