package com.issoft.store;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Product> products;

    public void setName(String name){
        this.name = name;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

}
