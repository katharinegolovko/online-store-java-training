package com.issoft.store;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private ArrayList<Category> categories;
    private static Store instance;
    private List<Product> purchasedProducts = new ArrayList<>();
    private Store(){
    }
    public static Store getInstance(){
        if (instance == null){
            instance = new Store();
        }
        return instance;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
}
