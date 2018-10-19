package com.learning.basics.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class hashMapComputeExs {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "10");
		map.put("2", "20");
		map.put(null, "100");

		Function<String, String> function = new MyFunction();
		map.computeIfAbsent("3", function); //key not present
		map.computeIfAbsent("2", function); //key already present
		
		//lambda way
		map.computeIfAbsent("4", v -> {return v;});
		map.computeIfAbsent("5", v -> {return null;}); //null value won't get inserted
		System.out.println(map);
		
		System.out.println("map before compute = "+map);
		for (String key : map.keySet()) {
			map.compute(key, (k,v) -> {return k+v;});
		}
		map.compute("5", (k,v) -> {return k+v;}); //key not present, v = null
		System.out.println("map after compute = "+map);
		
	}

}

class MyFunction implements Function<String, String> {

	@Override
	public String apply(String t) {
		return t;
	}
	
}