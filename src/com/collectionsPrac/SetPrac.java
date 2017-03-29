package com.collectionsPrac;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPrac<T> {

	private Set<T> set;
	
	public Set getSet() {

		if (this.set == null) {
			this.set = new HashSet<T>();
		}

		return this.set;
	}
	
	public static void fillSet(Set<String> set, String[] strs) {
		for (String str : strs) {
			set.add(str);
		}
	}
	
	public static void printSet(Set set) {
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void printSet2(Set<String> set) {
		for(String s:set){
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetPrac<String> prac = new SetPrac<String>();
		String[] testStrs = { "app", "pc", "web"};
		
		Set<String> set = prac.getSet();
		SetPrac.fillSet(set, testStrs);
		
		SetPrac.printSet2(set);
	}

}
