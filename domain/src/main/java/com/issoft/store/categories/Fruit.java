package com.issoft.store.categories;

import com.issoft.store.Category;

public class Fruit extends Category {
    private static Fruit instance;
    private Fruit(){
    }
    public static Fruit getInstance(){
        if (instance == null){
            instance = new Fruit();
        }
        return instance;
    }
     private String nameFruit = "Fruit";

    @Override
    public void setName(String name) {
        super.setName(nameFruit);
    }
}
