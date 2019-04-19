package com.patterns;

/**
 * @author 212331901
 * @date 2019/4/19
 */
public class ProductServiceImpl implements ProductService, ProductPrice{

    private String product;

    @Override
    public void addProduct(String name) {
        System.out.println("adding product: " + name);
        this.product = name;
    }

    @Override
    public String getProcut() {
        System.out.println("getting product: " + product);
        return this.product;
    }

    @Override
    public void setPrice(float price ) {
        System.out.println("adding product: " + price);
    }
}
