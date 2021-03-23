package com.issoft.store;

public class Product {

    private String name;
    private int rate;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }


    //public com.issoft.store.Product(String name, int rate, double price){
        //this.name = name;
       // this.rate = rate;
        //this.price = price;
    //}
}
