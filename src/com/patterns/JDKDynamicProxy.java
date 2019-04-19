package com.patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class JDKDynamicProxy {

    public static void main(String[] args) {
        ProductServiceImpl productService = new ProductServiceImpl();

        ClassLoader classLoader = productService.getClass().getClassLoader();

        /**
         * get all interfaces of the target object
         */
        Class[] interfaces = productService.getClass().getInterfaces();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("checking before invoking..." + method.getName());
                Object result = method.invoke(productService, args);
                System.out.println("invoking finished.");
                return result;            }
        };

        Object object = Proxy.newProxyInstance(classLoader, interfaces, handler);

        ProductService myproxy = (ProductService) object;
        myproxy.addProduct("AABB");
        myproxy.getProcut();

        ProductPrice priceProxy = (ProductPrice) object;
        priceProxy.setPrice(3.16f);
    }
}
