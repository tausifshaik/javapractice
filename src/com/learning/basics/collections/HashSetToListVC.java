package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetToListVC {

	public static void main(String[] args) {
		Set<String> vowels = new HashSet<>();
		vowels.add("a"); vowels.add("e"); vowels.add("i");
		
		//set to list example
		List<String> vowelsList = new ArrayList<>(vowels);
		System.out.println("vowels set = "+vowels);
		System.out.println("vowelsList = "+vowelsList);
		
		vowels.add("o");
		vowelsList.add("a");vowelsList.add("u");
		System.out.println("vowels set = "+vowels);
		System.out.println("vowelsList = "+vowelsList);
		
		//list to set example
		vowels = new HashSet<>(vowelsList);
		System.out.println("vowels set = "+vowels);

	}

}
