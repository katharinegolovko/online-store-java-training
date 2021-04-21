package com.issoft.store.director;

import com.issoft.store.Category;
import com.issoft.store.Store;
import com.issoft.store.builders.BookBuilder;
import com.issoft.store.builders.FruitBuilder;
import com.issoft.store.builders.VegetableBuilder;

import java.util.ArrayList;

public class Director {

    public Store createStore(){
        Store store = Store.getInstance();
        FruitBuilder fruitBuilder = new FruitBuilder();
        VegetableBuilder vegetableBuilder = new VegetableBuilder();
        BookBuilder bookBuilder = new BookBuilder();
        ArrayList<Category> storeCategories = new ArrayList<>();
        storeCategories.addAll(fruitBuilder.populateProductLists());
        storeCategories.addAll(bookBuilder.populateProductLists());
        storeCategories.addAll(vegetableBuilder.populateProductLists());
        store.setCategories(storeCategories);
        return store;
    }
}
