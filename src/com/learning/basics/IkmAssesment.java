package com.learning.basics;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Indc{
	public String s;
	public List<Integer> lst;
	public Indc(String s){
		this.s = s;
		lst = new LinkedList<>();
		for(int i=0;i<this.s.length();i++){
			lst.add(i);
		}
		System.out.println(lst);
		
	}
}
class Indc1{
	
	public Indc1(){
		
		
	}
}
interface I1{
	
	
}
interface I2 extends I1{
	String name = "N2";
}
public class IkmAssesment extends Indc1 implements I1 {
	
	public IkmAssesment(){
		
	}
	
	public static void main(String[] args) throws IOException {
		
		/*Optional<String> f = Optional.of("File1.java");
		File f1 = new File(f.get());
		Reader iout = new FileReader(f1);*/
		Stream.of(new Indc("mercury"),new Indc("venus"),new Indc("earth"))
		.flatMap(i -> i.lst.stream())
		.mapToInt(j -> j)
		.max()
		.ifPresent(s -> System.out.println(s));
		
		/*FileWriter out = new FileWriter(f);
		PrintWriter p = new PrintWriter(out);
		Stream.of('0','1').forEach(p::write);
		try {
			//Stream.of('0','1').forEach(out::write);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.write(new char[]{'0','1'});
		for(int i =0;i<5;i++){
			//f.sew
		}
			//out.write(String.valueOf(i));
		out.flush();*/
		
		
		/*System.out.println(I2.name);
		System.out.println(I2.s1);
		System.out.println(((I1)new IkmAssesment()).name);
		
		
		
		IkmAssesment ik = new Indc1();
		Indc1 in = new IkmAssesment();
		I1  i = new IkmAssesment();
		
		Object obj = new IkmAssesment();
		ik.myMeth(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		*/
	}

	private void myMeth(Runnable runnable) {
		// TODO Auto-generated method stub
		
	}

}
