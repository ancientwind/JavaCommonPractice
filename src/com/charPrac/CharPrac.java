package com.charPrac;

import com.util.PrintUtil;

import java.nio.charset.Charset;
import java.util.Base64;

public class CharPrac {

	public void basicOper(){
		/**
		 * Unicode is a computing industry standard designed to consistently and uniquely encode characters used in written languages throughout the world.
		 * The Unicode standard uses hexadecimal to express a character.
		 * For example, the value 0x0041 represents the Latin character A.
		 */
		// Unicode
		char uniChar = '\u032A';
		PrintUtil.print(uniChar);
		
		char c1 = 'a';
		
		PrintUtil.print("c1 is a letter? >> " + Character.isLetter(c1));
		
	}
	
	/**
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

	public void withString() {

		System.out.println(Charset.defaultCharset());
		Character a = 'a';
		System.out.println(a.charValue());

		String stra = "a";
		byte[] bytes1 = stra.getBytes();
		System.out.println(bytes1);
		System.out.println(new String(bytes1));

		Charset charsetUTF8 = Charset.forName("UTF-8");
		byte[] bytes2 = stra.getBytes(charsetUTF8);
		System.out.println(bytes2);
		System.out.println(new String(bytes2));

		Charset charsetUnicode = Charset.forName("Unicode");
		System.out.println(new String(stra.getBytes(charsetUnicode)));

		System.out.println("using base64 encoding============");
		// String -> bytes( encode with UTF-8) -> encode to base64 bytes
		byte[] base64 = Base64.getEncoder().encode(bytes1);
		System.out.println(base64);
		System.out.println(new String(base64)); // ASCII text
		byte[] decode = Base64.getDecoder().decode(base64);
		System.out.println(decode);
		System.out.println(new String(decode));
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

		prac.withString();
	}

}
