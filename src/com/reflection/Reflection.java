package com.reflection;

import com.util.PrintUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        PrintUtil printUtil = new PrintUtil();

        Class cls = printUtil.getClass();
        System.out.println(cls.getName());

//        Constructor constructor = cls.getConstructor();
//        System.out.println(constructor.getName());
        Constructor[] constructors = cls.getConstructors();
        Arrays.stream(constructors).forEach( constructor -> {
            System.out.println(constructor.getName());
            System.out.println(constructor.getParameterCount());
            System.out.println(constructor.getParameterTypes());
        });

        Constructor constructor = PrintUtil.class.getConstructor(String.class);
        PrintUtil printUtil2 = (PrintUtil) constructor.newInstance("Goodman");
        System.out.println(printUtil2.getName());

        Method[] methods = cls.getMethods();
        System.out.println("===Methods in this class: ");
        Arrays.stream(methods).forEach( method -> System.out.println(method.getName()));
        System.out.println("===Listed Methods end.");

        Method setName = cls.getDeclaredMethod("setName", String.class);
        setName.invoke(printUtil, "jimmy");
        System.out.println(printUtil.getName());

        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(printUtil, "saul");
        System.out.println(printUtil.getName());

        Field field1 = cls.getDeclaredField("character");
        System.out.println(field1.getName());
        System.out.println(field1.getType());

        Field field2 = cls.getDeclaredField("characters");
        System.out.println(field2.getName());
        System.out.println(field2.getType());
    }
}
