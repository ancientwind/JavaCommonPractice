package com.charPrac;

import com.util.PrintUtil;

public class CharPrac {

	public void basicOper(){
		// Unicode
		char uniChar = '\u032A';
		PrintUtil.print(uniChar);
		
		char c1 = 'a';
		
		PrintUtil.print("c1 is a letter? >> " + Character.isLetter(c1));
		
	}
	
	/*
	 * change all lower letters to upper
	 */
	public void changeAllToUpper(char[] chars) {
//		for(char ch:chars)
//			if(Character.isLowerCase(ch))
//				ch = Character.toUpperCase(ch); // This one won't work because ch is temp.
		
		for(int i = chars.length - 1; i >= 0; i--)
			if (Character.isLowerCase(chars[i]))
				chars[i] = Character.toUpperCase(chars[i]);
		
	}
	
	public static void main(String[] args) {
		
		CharPrac prac = new CharPrac();
		prac.basicOper();
		
		/**
		 * Test changeAllToUpper()
		 */
		char[] chars = { 'd', 'D', 'g', 'e'};
		
		PrintUtil.print(String.valueOf(chars));
		prac.changeAllToUpper(chars);
		PrintUtil.print(String.valueOf(chars));
	}

}
