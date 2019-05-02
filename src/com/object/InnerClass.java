package com.object;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class InnerClass {

    public static AtomicInteger counter = new AtomicInteger(1);

    private String level;

    /**
     * As a side note, we can’t have static method in a nested inner class
     * because an inner class is implicitly associated with an object of its outer class
     * so it cannot define any static method for itself.
     */
    class NestedInnerClass {
        public static final String NAME = "common inner ";

        public void echo() {
            System.out.println(NAME + counter.getAndIncrement());
        }
    }

    public void innerClassInMethod() {
        System.out.println("inside a method");
        int age = 10;
        String[] location = {"in method"};

        class MethodLocalInnerClass {
            private String name = "MethodLocalInnerClass ";

            public void echo() {
                System.out.println(name + counter.getAndIncrement());
                level = "method level";
                System.out.println("out level is: " + level);
                /**
                 * Local inner class cannot access non-final local variable till JDK 1.7. Since JDK 1.8,
                 * it is possible to access the non-final local variable in method local inner class.
                 *
                 * but could not modify it, like age++
                 */
                System.out.println(age);
                /**
                 * could change the value in the object though
                 */
                location[0] = "inside";
                System.out.println(Arrays.toString(location));
            }
        }

        MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
        methodLocalInnerClass.echo();
    }

    /**
     * Static nested classes are not technically an inner class.
     * They are like a static member of outer class.
     */
    static class StaticNestedClass {
        public void echo() {
            System.out.println("StaticNestedClass");
        }
    }

    class Demo {
        void show() {
            System.out.println("i am in show method of super class");
        }
    }

    public void anonyInnerClass() {
        Demo demo = new Demo(){
          void show() {
              super.show();
              System.out.println("in anony innner class");
          }
        };
        demo.show();

        Hello hello = new Hello() {
            @Override
            public void hi() {
                System.out.println("hello from anony.");
            }
        };
        hello.hi();
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.new NestedInnerClass().echo();
        innerClass.innerClassInMethod();

        InnerClass.StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.echo();

        innerClass.anonyInnerClass();
    }
}