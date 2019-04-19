package com.patterns.singleton;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class StaticInnerLazy {
    private StaticInnerLazy() {
    }

    /**
     * this is thread safe guaranteed by java
     */
    private static class MyInstance {
        private static final StaticInnerLazy INSTANCE = new StaticInnerLazy();
    }

    public static final StaticInnerLazy getInstance() {
        return MyInstance.INSTANCE;
    }
}
