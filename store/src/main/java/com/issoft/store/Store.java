package com.issoft.store;

import java.util.ArrayList;

public class Store {

    private ArrayList<Category> categories;
    private static Store instance;
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
}
