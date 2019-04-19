package com.patterns.singleton;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class DoubleCheckLazy {
    private DoubleCheckLazy() {
    }

    private static volatile DoubleCheckLazy instance;

    public static DoubleCheckLazy getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazy.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazy();
                }
            }
        }

        return instance;
    }
}
