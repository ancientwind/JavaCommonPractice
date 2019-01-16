package com.java8;

import java.util.Optional;

/**
 * @author 212331901
 * @date 2019/1/16
 */
public class OptionalPrac {

    public static int sum(Optional<Integer> a, Optional<Integer> b) {
        if (a.isPresent() && b.isPresent()) {
            return a.get() + b.get();
        }

        return a.orElse(new Integer(1)) + b.orElse(new Integer(1));
    }

    public static void main(String[] args) {
        System.out.println(OptionalPrac.sum(Optional.ofNullable(null), Optional.of(3)));
    }
}
