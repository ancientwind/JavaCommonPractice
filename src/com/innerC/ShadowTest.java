package com.innerC;

import com.util.PrintUtil;

public class ShadowTest {

	public int size = 5;
	
	class FirstLevel {
		public int size = 1;
		
		void methodInFirst(int size) {
			PrintUtil.print("size = " + size);
			PrintUtil.print("this.size = " + this.size);
			PrintUtil.print("ShadowTest.size = " + ShadowTest.this.size );
		}
	}
	
	public static void main(String... args) {
		ShadowTest st = new ShadowTest();
		ShadowTest.FirstLevel st_first = st.new FirstLevel();
		st_first.methodInFirst(9);
	}
}
