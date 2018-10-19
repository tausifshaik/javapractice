package com.learning.basics.JavaIo;

import java.io.File;

public class FileSeparator {
	/*
	 * java.io.File class contains four static separator variables. Here we will learn about them and when to use it.
  		File.separator: Platform dependent default name-separator character as String. For windows, it’s ‘\’ and for unix it’s ‘/’.
		File.separatorChar: Same as separator but it’s char.
		File.pathSeparator: Platform dependent variable for path-separator. For example PATH or CLASSPATH variable list of paths separated by ‘:’ in Unix systems and ‘;’ in Windows system.
		File.pathSeparatorChar: Same as pathSeparator but it’s char.
	 */
	public static void main(String[] args) {
		System.out.println("File.separator = "+File.separator);
        System.out.println("File.separatorChar = "+File.separatorChar);
        System.out.println("File.pathSeparator = "+File.pathSeparator);
        System.out.println("File.pathSeparatorChar = "+File.pathSeparatorChar);
	}

}
