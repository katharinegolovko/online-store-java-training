package com.issoft.store;

import com.github.javafaker.Faker;
import com.issoft.store.categories.Book;
import com.issoft.store.categories.Fruit;
import com.issoft.store.categories.Vegetable;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

import static com.issoft.store.TestConstants.FRUIT;
import static com.issoft.store.TestConstants.BOOK;
import static com.issoft.store.TestConstants.VEGETABLE;

public final class RandomStorePopulator {

    Faker faker = new Faker();

    public Product createProduct(String product) {
        if (product == FRUIT) {
            return createProductConstructor(faker.food().fruit(), faker.number().numberBetween(0, 5),faker.number().numberBetween(0, 50));
        } if (product == VEGETABLE) {
            return createProductConstructor(faker.food().vegetable(), faker.number().numberBetween(0, 5),faker.number().numberBetween(0, 35));
        } else if (product == BOOK) {
            return createProductConstructor(faker.book().title(), faker.number().numberBetween(0, 5),faker.number().numberBetween(0, 40));
        } else {
            Product createdProduct = Product.newBuilder()
                    .build();
            return createdProduct;
        }
    }

    private Product createProductConstructor(String productName, int productRate, double productPrice){
        Product createdProduct = Product.newBuilder()
                .setProductName(productName)
                .setProductRate(productRate)
                .setProductPrice(productPrice)
                .build();
        return createdProduct;
    }

    public ArrayList<Product> populateCategory(String name, int quantity) {
        ArrayList<Product> productList = new ArrayList<Product>();
        for (int i = quantity; i > 0; i--) {
            Product product = createProduct(name);
            productList.add(product);
        }
        return productList;
    }

    public ArrayList<Category> populateProductLists() {
        ArrayList<Category> productList = new ArrayList<Category>();
        Fruit fruitCategory = new Fruit();
        fruitCategory.setName(FRUIT);
        fruitCategory.setProducts(populateCategory(FRUIT, 2));
        Vegetable vegetableCategory = new Vegetable();
        vegetableCategory.setName(VEGETABLE);
        vegetableCategory.setProducts(populateCategory(VEGETABLE, 3));
        Book bookCategory = new Book();
        bookCategory.setName(BOOK);
        bookCategory.setProducts(populateCategory(BOOK, 2));
        productList.add(fruitCategory);
        productList.add(vegetableCategory);
        productList.add(bookCategory);
        return productList;
    }


    public List<Category> extractDataFromStore(Store store) throws IllegalAccessException {
        Set<Field> fields = ReflectionUtils.getFields(Store.class);
        Field f = fields.iterator().next();
        f.setAccessible(true);
        Object data = f.get(store);
        return (List<Category>) data;
    }

    public List<Product> extractDataFromCategory(Category category) throws IllegalAccessException {
        Set<Field> fields = ReflectionUtils.getFields(Category.class);
        Field f = fields.iterator().next();
        f.setAccessible(true);
        Object data = f.get(category);
        return (List<Product>) data;
    }

    public void pretty(List<Category> store) {
        for (Category category : store) {
            System.out.print("Category: " + category.getName() + " \n");
            for (Product product : category.getProducts()) {
                String pattern = "   Product: name=%s, rate=%s, price=%s ";
                System.out.println(String.format(pattern, product.getName(), product.getRate(), product.getPrice()));
            }
        }

    }

    public void prettyProducts(List<Product> category) {
        for (Product product : category) {
            String pattern = "   Product: name=%s, rate=%s, price=%s ";
            System.out.println(String.format(pattern, product.getName(), product.getRate(), product.getPrice()));
        }
    }


}

