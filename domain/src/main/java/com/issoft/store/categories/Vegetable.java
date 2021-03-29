package com.issoft.store.categories;

import com.issoft.store.Category;

public class Vegetable extends Category {
    private String nameVegetable = "Vegetable";

    @Override
    public void setName(String name) {
        super.setName(nameVegetable);
    }

}
