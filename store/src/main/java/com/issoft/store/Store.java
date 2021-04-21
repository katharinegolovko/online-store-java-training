package com.issoft.store;

import java.util.ArrayList;

public final class Store {

    private static Store instance;
    private Store(){
    }
    public static Store getInstance(){
        if (instance == null){
            instance = new Store();
        }
        return instance;
    }

    private ArrayList<Category> categories;

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
