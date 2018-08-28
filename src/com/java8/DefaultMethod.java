package com.java8;

public class DefaultMethod implements Clickable, Accessible{

    /**
     * same method in both interface, need to specify the behavior of this method
     */
    @Override
    public void print() {
        Clickable.super.print();
    }

    public void check() {
        System.out.println("DefaultMethod check");
    }

    public static void main(String[] args) {
        DefaultMethod dm = new DefaultMethod();
        dm.access();
        dm.click();
        dm.print();

        Accessible.check();
        dm.check();
    }
}
