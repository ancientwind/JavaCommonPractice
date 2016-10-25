package com.stringTest;

import com.util.Util;

public class StringBasicPrac {

	public void printFormatString() {
		String str;
		float f1 = 3.46f;
		int a1 = 535;
		String s1 = "Hello";
		str = String.format("浮点型变量的的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", f1, a1, s1);
		Util.print(str);
	}
	
	public static void main(String[] args) {
		StringBasicPrac prac = new StringBasicPrac();
		prac.printFormatString();
	}

}
