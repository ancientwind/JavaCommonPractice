package com.patterns.singleton;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class DoubleCheckLazy {
    private DoubleCheckLazy() {
    }

    /**
     * without volatile:
     *
     * getInstance()看似解决了问题，但是有个很大的隐患。实例化对象的那行代码（标记为error的那行），实际上可以分解成以下三个步骤：
     *
     * 1.分配内存空间
     * 2. 初始化对象
     * 3. 将对象指向刚分配的内存空间
     * 但是有些编译器为了性能的原因，可能会将第二步和第三步进行重排序，顺序就成了：
     *
     * 1. 分配内存空间
     * 2. 将对象指向刚分配的内存空间
     * 3. 初始化对象
     *
     * 其他线程可能访问到一个未初始化完成的对象
     */
    /**
     * with volatile:
     *
     * 使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
     *
     * 至此，双重检查锁就可以完美工作了。
     */
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
