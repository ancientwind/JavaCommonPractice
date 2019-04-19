package com.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class ProductInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public ProductInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("checking before invoking...");
        Object result = method.invoke(targetObject, args);
        System.out.println("invoking finished.");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        ProductInvocationHandler handler = new ProductInvocationHandler(new ProductServiceImpl());

        ProductService myproxy = (ProductService) handler.getProxy();
        myproxy.addProduct("Apple");
        myproxy.getProcut();
    }
}
