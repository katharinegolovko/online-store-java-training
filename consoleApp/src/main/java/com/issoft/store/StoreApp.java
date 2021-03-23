package com.issoft.store;

import com.github.javafaker.Faker;

public class StoreApp {

    public static void main(String args[]){
        Product fruit1 = new Product();
        //System.out.println(fruit1);
        Faker faker = new Faker();

        //com.issoft.store.Fruit description
        String fruit = faker.food().fruit();
        int fruit_rate = faker.number().numberBetween(0,5);
        double fruit_price = faker.number().numberBetween(0, 19);

        System.out.println("Product1: " + fruit + " | Rate: " + fruit_rate + " | Price: " + fruit_price);

        //com.issoft.store.Vegetable description
        String vegetable = faker.food().vegetable();
        int vegetable_rate = faker.number().numberBetween(0,5);
        double vegetable_price = faker.number().numberBetween(0, 11);

        System.out.println("Product2: " + vegetable + " | Rate: " + vegetable_rate + " | Price: " + vegetable_price);

        //com.issoft.store.Book description
        String book = faker.book().title();
        int book_rate = faker.number().numberBetween(0,5);
        double book_price = faker.number().numberBetween(0, 45);

        System.out.println("Product3: " + book + " | Rate: " + book_rate + " | Price: " + book_price);





    }

}
