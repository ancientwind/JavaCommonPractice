package com.classload;

/**
 * @author 212331901
 * @date 2019/3/27
 */
public class IntializationTest2 {

    /**
     * 初始化
     */
    static int a = 3;
    /**
     * 准备
     */
    static final int b = 11;

    /**
     * 实例初始化
     */
    public IntializationTest2() {
        System.out.println("constructor");
    }

    /**
     * 类变量初始化，由于new引发实例初始化，并且并于到类变量初始化的过程中
     */
    static IntializationTest2 test = new IntializationTest2();

    /**
     * 类初始化
     */
    static {
        System.out.println(" static block.");
    }

    /**
     * 实例初始化
     */
    {
        System.out.println(" instance block.");
    }

    /**
     * 外部调用触发
     */
    static void init() {
        System.out.println("init Test2 by static method");
    }

    public static void main(String[] args) {
        new IntializationTest2();
        IntializationTest2.init();
    }

}
