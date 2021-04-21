package com.issoft.store.builders;

import com.github.javafaker.Faker;
import com.issoft.store.Category;
import com.issoft.store.Product;
import com.issoft.store.categories.Book;
import java.util.ArrayList;
import static com.issoft.store.TestConstants.BOOK;

public class BookBuilder implements Builder {

    Faker faker = new Faker();
    String productName;

    @Override
        public Product createProduct(String product) {
            productName = faker.book().title();
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
        Book bookCategory = Book.getInstance();
        bookCategory.setName(BOOK);
        bookCategory.setProducts(populateCategory(BOOK, 2));
        productList.add(bookCategory);
        return productList;
    }
    }
