package com.util;


public class PrintUtil {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Character character;
    private Character[] characters;

    public PrintUtil() {
    }

    public PrintUtil(String name) {
        this.name = name;
    }

    public static void print(Object st) {
		System.out.println(st);
	}
	
	public static void beforeOper() {
		PrintUtil.print("<<<<<<Before operation<<<<<<<<");
	}
	
	public static void afterOper() {
		PrintUtil.print("<<<<<<After operation<<<<<<<<<<<");
	}
	
	public static Double multiply(Double a, Double b) {
//		return (Double) (a * b);
		return a * b;
	}
	
	public static void main(String[] strs) {
		String str = "ab";
		Integer i = 15;
		
		Integer[] data = { 3, 5, 7 };
		
		PrintUtil.print(str.hashCode());
		PrintUtil.print(i.hashCode());
		PrintUtil.print(data.hashCode());
	}
}
 