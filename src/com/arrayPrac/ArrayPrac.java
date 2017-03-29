package com.arrayPrac;

import java.util.Arrays;

import com.util.PrintUtil;

public class ArrayPrac {

	public void printArray(int[] array) {
		PrintUtil.print(Arrays.toString(array));
	}
	
	public void printDeepArray(int[][] arrays) {
		PrintUtil.print(Arrays.deepToString(arrays));
	}
	
	public static int[] reverse(int[] array) {
		int[] result = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			result[array.length - i - 1] = array[i];
		}
		
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
		PrintUtil.beforeOper();
		prac.printArray(array);
		PrintUtil.afterOper();
		prac.printArray(prac.reverse(array));
		
		/**
		 * sort
		 */
		PrintUtil.print("afte sort array: ");
		Arrays.sort(array);
		prac.printArray(array);
	}

}
