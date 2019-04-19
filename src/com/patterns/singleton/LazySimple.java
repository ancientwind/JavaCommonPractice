package com.patterns.singleton;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class LazySimple {
    private LazySimple() {
    }

    private static LazySimple instance;

    /**
     * sync is multiple thread safe, but not efficient
     */
    public static synchronized LazySimple getInstance() {
        if (instance == null) {
            instance = new LazySimple();
        }
        return instance;
    }
}
