package com.stringTest;

public class StringTest {

	/**
	 * Parses a line of text and generates a key/value pair.
	 * @param line {@code (String)} - the line of text to parse for key/value pair.
	 * @return {@code String[2]} - an array containing the key and value Strings. 
	 * @exception NullPointerException if <B>line</B> is null.
	 */
	public static String[] getKeyValuePair(String line) 
	{
		
		String[] tokens = line.trim().replace("'", " ").replaceAll("\\s+", " ").split(" ");			// .replace(":", " ")
		
		String[] keyValuePair = new String[2];	
		keyValuePair[0] = tokens[0];
		keyValuePair[1] = (tokens.length > 1) ? tokens[1] : "";
		
		for(int i = 2; i < tokens.length; i++) {
			keyValuePair[1] += " " + tokens[i];
		}
				
		return keyValuePair;
	}
	
	public static String[] getEVKeyValuePair(String line) 
	{
		String[] keyValuePair = new String[2];
		keyValuePair[0] = line.substring(0,line.lastIndexOf(" ")).trim();
		keyValuePair[1] = line.substring(line.lastIndexOf(" ")).trim();
		
		if(keyValuePair[1].equals("null") || keyValuePair[1].equals("NULL")){
			keyValuePair[1] = "";
		}
		
		return keyValuePair;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "productId 	Discovery CT870";
		String str2 = "scanSets[0] ScanSetType.imageKeys[0] .ImageKeyType.imagePath 	/usr/g/sdc_image_pool/reserved/T/dms/1.2.840.113619.2.339.226724415761432799344593269314495239257/";
		
		String[] result1 = getKeyValuePair(str1);
		String[] result2 = getKeyValuePair(str2);
		
		System.out.println("result1: " + result1[0] + " "+ result1[1] );
		System.out.println("result2: " + result2[0] + " "+ result2[1] );
	}

}

