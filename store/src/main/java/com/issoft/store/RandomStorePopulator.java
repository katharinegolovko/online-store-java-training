package com.issoft.store;

import com.issoft.store.categories.Book;
import com.issoft.store.categories.Fruit;
import com.issoft.store.categories.Vegetable;
import java.sql.*;
import java.util.*;

import static com.issoft.store.TestConstants.FRUIT;
import static com.issoft.store.TestConstants.BOOK;
import static com.issoft.store.TestConstants.VEGETABLE;

public final class RandomStorePopulator {

    public List<Product> createProduct(String product) throws SQLException, ClassNotFoundException {

        Connection conn = DatabaseConnection.getInstance().connectToDatabase();
        Statement st = conn.createStatement();
        List<Product> productList = new ArrayList<>();

        if (product == FRUIT) {
            ResultSet rs1 = st.executeQuery("SELECT * FROM STORE where CATEGORY='Fruit'");
            while(rs1.next()) {

                String fruitName = rs1.getString("NAME");
                int fruitRate  = rs1.getInt("RATE");
                double fruitPrice = rs1.getDouble("PRICE");
                productList.add(createProductConstructor(fruitName, fruitRate, fruitPrice));
            }
            return productList;
        } else if (product == VEGETABLE) {
            ResultSet rs2 = st.executeQuery("SELECT * FROM STORE where CATEGORY='Vegetable'");
            while (rs2.next()) {

                String vegetableName = rs2.getString("NAME");
                int vegetableRate = rs2.getInt("RATE");
                double vegetablePrice = rs2.getDouble("PRICE");
                productList.add(createProductConstructor(vegetableName, vegetableRate, vegetablePrice));
            }
            return productList;
        }
        else if (product == BOOK) {
            ResultSet rs2 = st.executeQuery("SELECT * FROM STORE where CATEGORY='Book'");
            while (rs2.next()) {

                String bookName = rs2.getString("NAME");
                int bookRate = rs2.getInt("RATE");
                double bookPrice = rs2.getDouble("PRICE");
                productList.add(createProductConstructor(bookName, bookRate, bookPrice));
            }
            return productList;
        }
        else {
            return productList;
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

    public List<Product> populateCategory(String name) throws SQLException, ClassNotFoundException {
        List<Product> productList = createProduct(name);
        return productList;
    }

    public List<Category> populateProductLists() throws SQLException, ClassNotFoundException {
        List<Category> productList = new ArrayList<Category>();
        Fruit fruitCategory = new Fruit();
        fruitCategory.setName(FRUIT);
        fruitCategory.setProducts(populateCategory(FRUIT));
        Vegetable vegetableCategory = new Vegetable();
        vegetableCategory.setName(VEGETABLE);
        vegetableCategory.setProducts(populateCategory(VEGETABLE));
        Book bookCategory = new Book();
        bookCategory.setName(BOOK);
        bookCategory.setProducts(populateCategory(BOOK));
        productList.add(fruitCategory);
        productList.add(vegetableCategory);
        productList.add(bookCategory);
        return productList;
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

    public void prettyProduct(Product product) {
            String pattern = "   Product: name=%s, rate=%s, price=%s ";
            System.out.println(String.format(pattern, product.getName(), product.getRate(), product.getPrice()));
    }
}


