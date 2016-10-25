package com.arrayPrac;

import java.util.Arrays;

import com.util.Util;

public class ArrayPrac {

	public void printArray(int[] array) {
		Util.print(Arrays.toString(array));
	}
	
	public void printDeepArray(int[][] arrays) {
		Util.print(Arrays.deepToString(arrays));
	}
	
	public static int[] reverse(int[] array) {
		int[] result = new int[array.length];
		
		for(int i = array.length - 1, j = 0; i >=0; i--,j++) 
			result[j] = array[i];
		
		return result;
	}
	
	public static void main(String[] args) {

		ArrayPrac prac = new ArrayPrac();
		
		/**
		 * print deep arrays
		 */
		int[][] arrays = new int[][] {
			{4,7,5},{2,6,9}
		};
		prac.printDeepArray(arrays);
		
		/*
		 * test reverse
		 */
		int[] array = {3,6,1,6,2};
		Util.beforeOper();
		prac.printArray(array);
		Util.afterOper();
		prac.printArray(prac.reverse(array));
		
		/**
		 * sort
		 */
		Util.print("afte sort array: ");
		Arrays.sort(array);
		prac.printArray(array);
	}

}
