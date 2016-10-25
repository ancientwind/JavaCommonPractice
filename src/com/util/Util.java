package com.util;


public class Util {

	public static void print(Object st) {
		System.out.println(st);
	}
	
	public static void beforeOper() {
		Util.print("<<<<<<Before operation<<<<<<<<");
	}
	
	public static void afterOper() {
		Util.print("<<<<<<After operation<<<<<<<<<<<");
	}
	
	public static Double multiply(Double a, Double b) {
//		return (Double) (a * b);
		return a * b;
	}
}
