package com.issoft.store;

import com.github.javafaker.Faker;
import com.issoft.store.categories.Book;
import com.issoft.store.categories.Fruit;
import com.issoft.store.categories.Vegetable;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.issoft.store.TestConstants.FRUIT;
import static com.issoft.store.TestConstants.BOOK;
import static com.issoft.store.TestConstants.VEGETABLE;

public final class RandomStorePopulator {

    Faker faker = new Faker();

    public Product createProduct(String product) {
        String productName;
        if (product == FRUIT) {
            productName = faker.food().fruit();
        } else if (product == VEGETABLE) {
            productName = faker.food().vegetable();
        } else if (product == BOOK) {
            productName = faker.book().title();
        } else {
            productName = "Unrecognized product";
        }
        int productRate = faker.number().numberBetween(0, 5);
        double productPrice = faker.number().numberBetween(0, 19);
        Product product2 = new Product(productName, productRate, productPrice);
        return product2;
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

    public void pretty(List<Category> store) {
        for (Category category : store) {
            System.out.print("Category: " + category.getName() + " \n");
            for (Product product : category.getProducts()) {
                String pattern = "   Product: name=%s, rate=%s, price=%s ";
                System.out.println(String.format(pattern, product.getName(), product.getRate(), product.getPrice()));
            }
        }

    }
}

