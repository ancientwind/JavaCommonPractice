package com.util;

/**
 * 
 * Java basic data types(内置数据类型) and operations
 * 
 * Java语言为每�?个内置数据类型提供了对应的包装类�?
 * 
 * @author wayne.zeng
 *
 */
public class BasicDataType {

	public static void main(String[] args) {

		BasicDataType dt = new BasicDataType();
//		BasicDataType.printInnerDataType();
//		dt.byteOperation();
		int a = 32;
		byte b = 1;
		System.out.println(Integer.BYTES);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Byte.BYTES);
		System.out.println(Byte.toString(b));
		System.out.println(b + 1);
		System.out.println(b<<1);
	}
	
	/**
	 * variable x = (expression) ? value if true : value if false
	 */
	public void tripleOper(){
		int a = 3;
		int b = (a > 0) ? 0 : 1;
		//This one is false: (b == 0) ? System.out.println("a > 0"),System.out.println("a < 0");
	}
	
	//explain of byte operation
	public void byteOperation(){
		int a = -7;
		int b = 5;
		
		System.out.println("a = " + a + "; b = " + b + " ; a&b: " + (a&b) );
		System.out.println("a|b: " + (a|b));
		System.out.println("a^b: " + (a^b));
		System.out.println("~b: " + ~b);
		System.out.println("<<: 逻辑左移，右位补零；a<<2: " + (a<<2) );
		System.out.println(">>: 带符号右移，左位补符�?-正数�?0，负数补1；a>>2�?" + (a>>2));
		System.out.println(">>>: 无符号右移，左位补零；a>>>2: " + (a>>>2));

	}
	
	public void byteExample(){
	     int a = 60; /* 60 = 0011 1100 */ 
	     int b = 13; /* 13 = 0000 1101 */
	     int c = 0;
	     c = a & b;       /* 12 = 0000 1100 */
	     System.out.println("a & b = " + c );

	     c = a | b;       /* 61 = 0011 1101 */
	     System.out.println("a | b = " + c );

	     c = a ^ b;       /* 49 = 0011 0001 */
	     System.out.println("a ^ b = " + c );

	     c = ~a;          /*-61 = 1100 0011 */
	     System.out.println("~a = " + c );

	     c = a << 2;     /* 240 = 1111 0000 */
	     System.out.println("a << 2 = " + c );

	     c = a >> 2;     /* 15 = 1111 */
	     System.out.println("a >> 2  = " + c );
	  
	     c = a >>> 2;     /* 15 = 0000 1111 */
	     System.out.println("a >>> 2 = " + c );
	}
	
	/**
	 * java 用二进制补码来表示和存储数�??
	 */
	public static void printInnerDataType() {
		// byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("�?小�?�：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("�?大�?�：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
  
        // short  
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);  
        System.out.println("包装类：java.lang.Short");  
        System.out.println("�?小�?�：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("�?大�?�：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();  
  
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("�?小�?�：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("�?大�?�：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("�?小�?�：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("�?大�?�：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("�?小�?�：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("�?大�?�：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("�?小�?�：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("�?大�?�：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式�?�不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("�?小�?�：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式�?�不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("�?大�?�：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);  
	}

}
