package com.patterns;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class ProductInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercepting the method: " + method.getName());
        methodProxy.invokeSuper(o, args);
        System.out.println("intercepting finished.");
        return null;
    }
}
