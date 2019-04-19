package com.patterns;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class CGLibProxy {
    public static void main(String[] args) {
        ProductServiceImpl productService = new ProductServiceImpl();

        ProductInterceptor productInterceptor = new ProductInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(productService.getClass());
        enhancer.setCallback(productInterceptor);

        ProductServiceImpl myproxy = (ProductServiceImpl) enhancer.create();
        myproxy.addProduct("jimmy");
        myproxy.getProcut();
        myproxy.setPrice(3251.5323f);
    }
}
