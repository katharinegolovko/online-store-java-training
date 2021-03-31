package com.issoft.store.categories;

import com.issoft.store.Category;

public class Fruit extends Category {
     private String nameFruit = "Fruit";

    @Override
    public void setName(String name) {
        super.setName(nameFruit);
    }
}
