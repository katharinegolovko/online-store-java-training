package com.issoft.store.categories;

import com.issoft.store.Category;

public class Vegetable extends Category {
    private static Vegetable instance;
    private Vegetable(){
    }
    public static Vegetable getInstance(){
        if (instance == null){
            instance = new Vegetable();
        }
        return instance;
    }
    private String nameVegetable = "Vegetable";

    @Override
    public void setName(String name) {
        super.setName(nameVegetable);
    }

}
