package com.patterns;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class StaticProxy implements ProductService{

    private ProductService concreteService;

    public StaticProxy(ProductService concreteService) {
        this.concreteService = concreteService;
    }

    @Override
    public void addProduct(String name) {
        System.out.println("Static Proxy taking...");
        this.concreteService.addProduct(name);
        System.out.println("Static Proxy finished.");
    }

    @Override
    public String getProcut() {
        return null;
    }

    public static void main(String[] args) {
        StaticProxy myProxy = new StaticProxy(new ProductServiceImpl());
        myProxy.addProduct("Power Computer");
    }
}
