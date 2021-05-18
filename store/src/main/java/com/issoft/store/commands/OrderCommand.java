package com.issoft.store.commands;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OrderCommand {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public Product execute(List<Product> products) throws IOException {
        System.out.println("What Product do you want to buy? Please enter the number of the Product from the Product List. All available Products you can observe using Sort and Top commands.");
        int i = 1;
        while (i >= 1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userChoice = reader.readLine();
            int productIndex = Integer.parseInt(userChoice) - 1;

            if (productIndex >= 0 && productIndex <= products.size() - 1) {
                product = products.get(productIndex);
                RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
                System.out.println("The Product you selected is:");
                randomStorePopulator.prettyProduct(product);
                i = 0;
            } else {
                System.out.println("You have entered incorrect number of Product. Please check Products in the Product List and enter number of selected Product again.");
            }
        }
        return product;
    }
}
