package com.stringTest;

import com.util.PrintUtil;

public class StringBasicPrac {

	public void printFormatString() {
		String str;
		float f1 = 3.46f;
		int a1 = 535;
		String s1 = "Hello";
		str = String.format("�����ͱ����ĵ�ֵΪ " +
                "%f, ���ͱ�����ֵΪ " +
                " %d, �ַ���������ֵΪ " +
                " %s", f1, a1, s1);
		PrintUtil.print(str);
	}
	
	public static void main(String[] args) {
		StringBasicPrac prac = new StringBasicPrac();
		prac.printFormatString();
	}

}
