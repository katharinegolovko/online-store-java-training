package com.issoft.store.categories;

import com.issoft.store.Category;

public class Book extends Category {
    private static Book instance;
    private Book(){
    }
    public static Book getInstance(){
        if (instance == null){
            instance = new Book();
        }
        return instance;
    }
    private String nameBook = "Book";

    @Override
    public void setName(String name) {
        super.setName(nameBook);
    }
}
