package com.issoft.store;


import com.sun.xml.internal.ws.api.server.Module;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Set;

public class StoreApp {

    public static void main(String args[]){

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        ArrayList<Category> categoryList = randomStorePopulator.populateStore();
        String output = categoryList.toString().replaceAll("(^\\[|\\]$)", "");
        System.out.println(output);

        Reflections reflections = new Reflections("my.package");



        }






        /*Faker faker = new Faker();

        String fruit = faker.food().fruit();
        int fruitRate = faker.number().numberBetween(0,5);
        double fruitPrice = faker.number().numberBetween(0, 19);

        String fruit3 = faker.food().fruit();
        int fruitRate3 = faker.number().numberBetween(0,5);
        double fruitPrice3 = faker.number().numberBetween(0, 19);

        Fruit fruitCategory = new Fruit();
        ArrayList<Product> myList1 = new ArrayList<Product>();
        Product fruit1 = new Product(fruit, fruitRate, fruitPrice);
        Product fruit2 = new Product(fruit3, fruitRate3, fruitPrice3);
        myList1.add(fruit1);
        myList1.add(fruit2);





       /* for (Product product: myList1) {
            System.out.println(product.getName());
            System.out.println(product.getRate());
            System.out.println(product.getPrice());
        }

        */






        /*//System.out.println("Product1: " + fruit + " | Rate: " + fruit_rate + " | Price: " + fruit_price);

        //com.issoft.store.categories.Vegetable description
        String vegetable = faker.food().vegetable();
        int vegetable_rate = faker.number().numberBetween(0,5);
        double vegetable_price = faker.number().numberBetween(0, 11);

        System.out.println("Product2: " + vegetable + " | Rate: " + vegetable_rate + " | Price: " + vegetable_price);

        //com.issoft.store.categories.Book description
        String book = faker.book().title();
        int book_rate = faker.number().numberBetween(0,5);
        double book_price = faker.number().numberBetween(0, 45);

        System.out.println("Product3: " + book + " | Rate: " + book_rate + " | Price: " + book_price);

        Fruit fruit2 = new Fruit();
        fruit2.setName("FruitTest");
        //System.out.println(fruit2.getName());



        //RandomStorePopulator store1 = new RandomStorePopulator();
        //store1.createProduct();
        //System.out.println(store1);

        Product testFruit1 = new Product(fruit, fruitRate, fruitPrice);
        //testFruit1.setName(faker.food().fruit());
        //testFruit1.setRate(faker.number().numberBetween(0,5));
        //testFruit1.setPrice(faker.number().numberBetween(0, 45));


        Fruit fruit3 = new Fruit();
        ArrayList<Product> myList1 = new ArrayList<Product>();
        myList1.add(new Product(fruit, fruitRate, fruitPrice));
        myList1.add(new Product(fruit, fruitRate, fruitPrice));

        Product test1 = myList1.get(1);
        System.out.println(myList1.toString());

        fruit3.setProducts(myList1);
        System.out.println(fruit3.getProducts());
*/

        //testFruit1.setName(faker.food().fruit());
        //testFruit1.setRate(faker.number().numberBetween(0,5));
        //testFruit1.setPrice(faker.number().numberBetween(0, 45));
        //System.out.println(testFruit1.getName());
        //System.out.println(testFruit1.getPrice());
        //System.out.println(testFruit1.getRate());









    }


