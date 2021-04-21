package com.issoft.store.builders;

import com.issoft.store.Category;
import com.issoft.store.Product;

import java.util.ArrayList;

public interface Builder {

    Product createProduct(String product);
    ArrayList<Product> populateCategory(String name, int quantity);
    public ArrayList<Category> populateProductLists();
}
