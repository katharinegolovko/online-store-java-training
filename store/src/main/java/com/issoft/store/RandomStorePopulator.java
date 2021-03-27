package com.issoft.store;

import com.github.javafaker.Faker;
import com.issoft.store.categories.Book;
import com.issoft.store.categories.Fruit;
import com.issoft.store.categories.Vegetable;

import java.util.ArrayList;

public final class RandomStorePopulator {

    Faker faker = new Faker();

    public Product createFruit(){
        String fruit = faker.food().fruit();
        int fruitRate = faker.number().numberBetween(0,5);
        double fruitPrice = faker.number().numberBetween(0, 19);
        Product frui1 = new Product(fruit, fruitRate, fruitPrice);
        return frui1;
    }

    public Product createVegetable(){
        String vegetable = faker.food().vegetable();
        int vegetableRate = faker.number().numberBetween(0,5);
        double vegetablePrice = faker.number().numberBetween(0, 15);
        Product vegetable1 = new Product(vegetable, vegetableRate, vegetablePrice);
        return vegetable1;
    }

    public Product createBook(){
        String book = faker.book().title();
        int bookRate = faker.number().numberBetween(0,5);
        double bookPrice = faker.number().numberBetween(0, 50);
        Product book1 = new Product(book, bookRate, bookPrice);
        return book1;
    }

    public ArrayList<Product> populateFruitCategory(){
        ArrayList<Product> fruitList = new ArrayList<Product>();
        Product fruit1 = createFruit();
        Product fruit2 = createFruit();
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        return fruitList;
    }

    public ArrayList<Product> populateVegetableCategory(){
        ArrayList<Product> vegetableList = new ArrayList<Product>();
        Product vegetable1 = createVegetable();
        Product vegetable2 = createVegetable();
        Product vegetable3 = createVegetable();
        vegetableList.add(vegetable1);
        vegetableList.add(vegetable2);
        vegetableList.add(vegetable3);
        return vegetableList;
    }

    public ArrayList<Product> populateBookCategory(){
        ArrayList<Product> bookList = new ArrayList<Product>();
        Product book1 = createBook();
        Product book2 = createBook();
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }

    public ArrayList<Category> populateStore(){
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Fruit fruitCategory = new Fruit();
        fruitCategory.setName("Fruit");
        fruitCategory.setProducts(populateFruitCategory());
        Vegetable vegetableCategory = new Vegetable();
        vegetableCategory.setName("Vegetable");
        vegetableCategory.setProducts(populateVegetableCategory());
        Book bookCategory = new Book();
        bookCategory.setName("Book");
        bookCategory.setProducts(populateBookCategory());
        categoryList.add(fruitCategory);
        categoryList.add(vegetableCategory);
        categoryList.add(bookCategory);
        return categoryList;
    }


    }

