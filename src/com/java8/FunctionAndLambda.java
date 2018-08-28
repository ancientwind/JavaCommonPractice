package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class FunctionAndLambda {

    public void toUpper(String greetings, FuncInterface funcInterface) {
        System.out.println(funcInterface.helloSingleMethod(greetings));
    }

    public void testMethodReference() {
        List<Integer> integerList = Arrays.asList(2,8,22,19,82);
        BiPredicate<List<Integer>, Integer> isPartOf = List::contains;
        BiPredicate<List<Integer>, Integer> isPartOfLambda = (List<Integer> list, Integer target) -> list.contains(target);
        System.out.println(isPartOf.test(integerList, 8));
        System.out.println(isPartOfLambda.test(integerList, 22));
    }

    public void testConstructorReference() {
        EmployeeFactory employeeFactory = Employee::new;
        Employee employee = employeeFactory.getEmployee("Jimmy", 37);
        System.out.println(employee.age);
    }

    public static void main(String[] args) {
        FunctionAndLambda fl = new FunctionAndLambda();
        fl.toUpper("have a nice day", (str) -> str.toUpperCase());
        fl.testMethodReference();
        fl.testConstructorReference();
    }
}

