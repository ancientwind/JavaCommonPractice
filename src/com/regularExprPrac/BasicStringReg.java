package com.regularExprPrac;

import com.util.PrintUtil;

/**
 * 
 * Strings in Java have built-in support for regular expressions. 
 * Strings have four built-in methods for regular expressions, 
 * i.e., the matches(), split()), replaceFirst() and replaceAll() methods. 
 * The replace() method does NOT support regular expressions.
 * 
 * @author 212331901
 *
 */
public class BasicStringReg {

	public static final String TEST = "This is  , my example .";
	
	public static void main(String[] args) {
		
		PrintUtil.print(TEST.matches("\\w.*"));
		
		String[] splitStr = TEST.split("\\s+");
		
		for(String str:splitStr)
			PrintUtil.print(str);
		
		PrintUtil.print(TEST.replaceAll("\\s+", "\t"));
		
		PrintUtil.print(BasicStringReg.removeWhitespace(TEST));
	}

	// Removes whitespace between a word character and . or ,
	// $1 means the first group of matches
	public static String removeWhitespace(String s){
		String pattern = "(\\w)(\\s+)([\\.,])";
		return s.replaceAll(pattern, "$1$3");
	}
}
