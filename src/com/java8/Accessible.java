package com.java8;

public interface Accessible {

    default void access(){
        System.out.println("access");
    }

    // could be override
    default void print(){
        System.out.println("Accessible");
    }

    //Java prevents overriding any method with the keyword static.
    static void check() {
        System.out.println("Interface Accessible check");
    }

}
