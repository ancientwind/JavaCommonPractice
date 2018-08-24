package com.java8;

/**
 * if there's only a single abstract method in the Interface,
 * then could not use the below annotation
 */
@FunctionalInterface
public interface FuncInterface {
    public String helloSingleMethod(String name);
}