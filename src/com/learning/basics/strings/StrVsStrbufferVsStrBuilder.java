package com.learning.basics.strings;

import java.util.GregorianCalendar;

public class StrVsStrbufferVsStrBuilder {

	/*
	 * String is immutable and final in java, so whenever we do String manipulation, it creates a new String.
	 *  String manipulations are resource consuming, so java provides two utility classes for String manipulations – StringBuffer and StringBuilder.
	 *  StringBuffer and StringBuilder are mutable classes.
	 *   StringBuffer operations are thread-safe and synchronized where StringBuilder operations are not thread-safe. 
	 *   So when multiple threads are working on same String, we should use StringBuffer but in single threaded environment we should use StringBuilder.
	 *   StringBuilder performance is fast than StringBuffer because of no overhead of synchronization.
	 */
	public static void main(String[] args) {
		System.gc();
		long start=new GregorianCalendar().getTimeInMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<10000000; i++){
			sb.append(":").append(i);
		}
		long end=new GregorianCalendar().getTimeInMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:"+(end-start));
		System.out.println("Memory used:"+(startMemory-endMemory));
	}

}
