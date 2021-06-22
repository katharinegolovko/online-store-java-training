package com.issoft.store;

import java.util.List;

public class Product {

    private String name;
    private int rate;
    private double price;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", price=" + price +
                '}';
    }

    private Product() {
    }

    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setProductName(String name) {
            Product.this.name = name;
            return this;
        }

        public Builder setProductRate(int rate) {
            Product.this.rate = rate;
            return this;
        }

        public Builder setProductPrice(double price) {
            Product.this.price = price;
            return this;
        }

        public Product build(){
            return Product.this;
        }

    }

    public static String productToString(List<Product> products) {
        String product = "";
        int productNumber = 1;
        for (Product item : products) {
            product += "  " + productNumber + ". " + item.getName() + ", price: " + item.getPrice() + ", rate: " + item.getRate() + "\n";
            productNumber++;
        }
        return product;
    }
}