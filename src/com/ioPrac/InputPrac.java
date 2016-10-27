package com.ioPrac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.util.Util;

public class InputPrac {

	public static void main(String[] args) {

		//			InputPrac.testSystemIn();
		InputPrac.testScanner();
	}
	
	public static void testSystemIn() throws IOException {

		BufferedReader buff = new BufferedReader(
				new InputStreamReader(System.in));
		
		Util.print("Enter characters, 'q' to storp");
		char ch;
		while((ch = (char) buff.read()) != 'q'){ //or use buff.readLine()
			Util.print(ch);
		}
	}
	
	public static void testScanner() {
		Scanner scan = new Scanner(System.in);
		
		//next()不能得到带有空格的字符串 
//		while(scan.hasNext()) {
//			String str = scan.next();
//			Util.print(str);
//			if(str.equals("end")) break;
//		}
		
		//nextLine()可以获得空白
		while(scan.hasNext()) {
			String str_line = scan.nextLine();
			Util.print(str_line);
		}
	}

}
