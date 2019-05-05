package com.classload;

/**
 * @author 212331901
 * @date 2019/3/27
 */
public class InitializationTest1 {
    static int staticVariable;
    int nonStaticVariable;
    String name;

    public InitializationTest1(String name) {
        this.name = name;
        System.out.println("Constructor." + this.name);
    }

    // Static initialization block:
    // Runs once (when the class is initialized)
    static {
        System.out.println("Static initialization.");
        staticVariable = 5;
        System.out.println(staticVariable);
    }

    // Instance initialization block:
    // Runs each time you instantiate an object
    {
        System.out.println("Instance initialization.");
        staticVariable = 7;
        nonStaticVariable = 7;
        System.out.println(staticVariable);
    }


    public static void main(String[] args) {
        new InitializationTest1("A");
        new InitializationTest1("B");
    }
}
