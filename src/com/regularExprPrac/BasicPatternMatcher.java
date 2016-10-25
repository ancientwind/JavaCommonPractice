package com.regularExprPrac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.util.Util;

/**
 * 
 * You first create a Pattern object which defines the regular expression. 
 * This Pattern object allows you to create a Matcher object for a given string. 
 * This Matcher object then allows you to do regex operations on a String.
 * 
 * Quantifier:
 * ?: {0,1}
 * +: {1, }
 * *: {0, }
 */
public class BasicPatternMatcher {

	public static final String TEST = "This is   my example.";

	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(TEST);
		
		while(matcher.find()){
			Util.print("Start index: " + matcher.start());
			Util.print("End index: " + matcher.end());
			Util.print(matcher.group());
		}
		
		Pattern p_replace = Pattern.compile("\\s+");
		Matcher m_replace = p_replace.matcher(TEST);
		Util.print(m_replace.replaceFirst("\\*"));
	}

}
