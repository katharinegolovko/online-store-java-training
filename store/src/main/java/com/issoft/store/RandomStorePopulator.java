package com.issoft.store;

import com.github.javafaker.Faker;
import com.issoft.store.categories.Book;
import com.issoft.store.categories.Fruit;
import com.issoft.store.categories.Vegetable;

import java.util.ArrayList;

public final class RandomStorePopulator {

    Faker faker = new Faker();

    public Product createProduct(String product){
        String product1;
        if(product == "Fruit"){
            product1 = faker.food().fruit();
        }
        else if(product == "Vegetable"){
            product1 = faker.food().vegetable();
        }
        else if (product== "Book"){
            product1 = faker.book().title();
        }
        else {
            product1="Unrecognized product";
        }
        int productRate = faker.number().numberBetween(0,5);
        double productPrice = faker.number().numberBetween(0, 19);
        Product product2 = new Product(product1, productRate, productPrice);
        return product2;
    }

    public ArrayList<Product> populateCategory(String name,int quantity){
        ArrayList<Product> productList = new ArrayList<Product>();
        if(name == "Fruit"){
            for(int i=quantity; i>0;i--){
                Product product = createProduct("Fruit");
                productList.add(product);
            }
        }
        else if(name== "Vegetable"){
            for(int i=quantity; i>0;i--){
                Product product = createProduct("Vegetable");
                productList.add(product);
            }
        }
        else if(name=="Book") {
            for(int i=quantity; i>0;i--){
                Product product = createProduct("Book");
                productList.add(product);
            }
        }
        else {
            for(int i=quantity; i>0;i--){
                Product product = createProduct("Unrecognized");
                productList.add(product);
            }
        }
        return productList;
    }


    public ArrayList<Category> populateStore(){
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Fruit fruitCategory = new Fruit();
        fruitCategory.setName("Fruit");
        fruitCategory.setProducts(populateCategory("Fruit", 2));
        Vegetable vegetableCategory = new Vegetable();
        vegetableCategory.setName("Vegetable");
        vegetableCategory.setProducts(populateCategory("Vegetable", 3));
        Book bookCategory = new Book();
        bookCategory.setName("Book");
        bookCategory.setProducts(populateCategory("Book", 2));
        categoryList.add(fruitCategory);
        categoryList.add(vegetableCategory);
        categoryList.add(bookCategory);
        return categoryList;
    }

    }

