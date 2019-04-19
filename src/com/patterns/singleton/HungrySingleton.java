package com.patterns.singleton;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
