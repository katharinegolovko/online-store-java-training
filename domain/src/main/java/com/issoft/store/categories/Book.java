package com.issoft.store.categories;

import com.issoft.store.Category;

public class Book extends Category {
    private String nameBook = "Book";

    @Override
    public void setName(String name) {
        super.setName(nameBook);
    }
}
