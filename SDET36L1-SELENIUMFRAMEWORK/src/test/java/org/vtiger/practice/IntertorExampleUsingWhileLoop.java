package org.vtiger.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntertorExampleUsingWhileLoop {

	public static void main(String[] args) {
	
	Set<String> set=new HashSet<>();
	set.add("Hi");
	set.add("Siva");
	set.add("Good Morning");
	set.add("Have a great Day");
	set.add("Bangalore");
	
	Iterator<String> itr = set.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}

	}

}
