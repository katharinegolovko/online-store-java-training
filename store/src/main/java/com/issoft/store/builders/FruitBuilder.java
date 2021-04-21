package com.issoft.store.builders;

import com.github.javafaker.Faker;
import com.issoft.store.Category;
import com.issoft.store.Product;
import com.issoft.store.categories.Fruit;
import java.util.ArrayList;

import static com.issoft.store.TestConstants.*;

public class FruitBuilder implements Builder {

    Faker faker = new Faker();
    String productName;

    @Override
    public Product createProduct(String product) {
        productName = faker.food().fruit();
        int productRate = faker.number().numberBetween(0, 5);
        double productPrice = faker.number().numberBetween(0, 19);
        Product createdProduct = new Product(productName, productRate, productPrice);
        return createdProduct;
    }

    @Override
    public ArrayList<Product> populateCategory(String name, int quantity) {
        ArrayList<Product> productList = new ArrayList<Product>();
        for (int i = quantity; i > 0; i--) {
            Product product = createProduct(name);
            productList.add(product);
        }
        return productList;
    }

    @Override
    public ArrayList<Category> populateProductLists() {
        ArrayList<Category> productList = new ArrayList<Category>();
        Fruit fruitCategory = Fruit.getInstance();
        fruitCategory.setName(FRUIT);
        fruitCategory.setProducts(populateCategory(FRUIT, 2));
        productList.add(fruitCategory);
        return productList;
    }
}
