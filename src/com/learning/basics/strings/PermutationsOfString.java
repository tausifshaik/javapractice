package com.learning.basics.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {
	
	public static ArrayList<String> computeAllPossiblePermutations(String str) {
		System.out.println("method entry"+str);
	    ArrayList<String> perms = new ArrayList<>();
	    if (str.length() == 1) {
	    	System.out.println("if"+str);
	        perms.add(str);
	        System.out.println(perms);
	    } else {
	    	System.out.println("else"+str);
	        String chr = str.substring(0,1);
	        String rest = str.substring(1);
	        ArrayList<String> subPerms = computeAllPossiblePermutations(rest);
	        System.out.println("before for"+str);
	        System.out.println("before for subPerms"+subPerms);
	        for (String s : subPerms ) {
	        	System.out.println("1 for"+str);
	            for (int j = 0; j <= s.length(); j++) {
	            	System.out.println("2 for"+str);
	                String newPerm = s.substring(0,j) + chr + s.substring(j);
	                System.out.println("2 for newperm"+newPerm);
	                System.out.println("2 for cr"+chr);
	                perms.add(newPerm);
	                System.out.println("3 for"+perms);
	            }
	        }
	    }
	    return perms;
	}

	
	public static Set<String> generatePerm(String input)
	{
	    Set<String> set = new HashSet<String>();
	    if (input == "")
	        return set;

	    Character a = input.charAt(0);
	    System.out.println("chr 1"+a);

	    if (input.length() > 1)
	    {
	        input = input.substring(1);
	        System.out.println("input substring:"+input);
	        Set<String> permSet = generatePerm(input);
	        System.out.println("permset:"+permSet);
	        for (String x : permSet)
	        {
	        	System.out.println("X:"+x);
	            for (int i = 0; i <= x.length(); i++)
	            {
	            	System.out.println("if block set value of a :"+a); 
	                set.add(x.substring(0, i) + a + x.substring(i));
	                System.out.println("if block set:"+set); 
	            }
	        }
	    }
	    else
	    {
	        set.add(a + "");
	        System.out.println("else block set added:"+set);
	    }
	    return set;
	}
	
	
	
	
	public static void main(String[] args) {
		
		PermutationsOfString permutationsOfString = new PermutationsOfString();
		
		/*
		 * No duplicates if we use Set
		 */
		Set<String> result = permutationsOfString.generatePerm("ABC");
		System.out.println(result);
		
		/*
		 * Duplicates will be found if we use arraylist
		 */
		
		ArrayList<String> allPerms = permutationsOfString.computeAllPossiblePermutations("ABC");
		System.out.println(allPerms);
		
		
	}

}
