package com.issoft.store;

import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public void setName(String name){
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName(){
        return name;
    }

    public List<Product> getProducts(){
        return products;
    }

    @Override
    public String toString() {
        return "\n Category{" +
                "name='" + name + '\'' +
                ",\n products=" + products +
                '}' ;
    }

}
