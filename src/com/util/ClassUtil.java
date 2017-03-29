package com.util;

import java.lang.reflect.Method;

public class ClassUtil {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

//		BasicDataType dt = new BasicDataType();
//		Class dt_class = dt.getClass();
//		Class dt_class = BasicDataType.class;
		Class dt_class = Class.forName("com.util.BasicDataType"); //forName shall be packageName+className
		BasicDataType dt = (BasicDataType) dt_class.newInstance();
		dt.byteExample();
		PrintUtil.print(dt_class);
		ClassUtil.listMethodsName(dt_class);
	}

	public static void listMethodsName(Class _class) {
		Method[] methods = _class.getMethods();
		for(Method method:methods)
			PrintUtil.print(method.getName());
	}
}
