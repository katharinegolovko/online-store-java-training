package com.issoft.store.handlers;

import com.issoft.store.Category;
import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;
import com.issoft.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class OrderHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Client connected to 'order'");
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category : Store.getInstance().getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }
        System.out.println("What Product do you want to buy? Please enter the number of the Product from the Product List. All available Products you can observe using Sort and Top commands.");
        int i = 1;
        Product product;
        while (i >= 1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userChoice = reader.readLine();
            int productIndex = Integer.parseInt(userChoice) - 1;

            if (productIndex >= 0 && productIndex <= extractedProducts.size() - 1) {
                product = extractedProducts.get(productIndex);

                String purchasedProduct = product.toString();
                final byte[] out = purchasedProduct.getBytes("UTF-8");

                httpExchange.sendResponseHeaders(200, out.length);

                OutputStream os = httpExchange.getResponseBody();
                os.write(out);
                os.close();
                i = 0;
            } else {
                System.out.println("You have entered incorrect number of Product. Please check Products in the Product List and enter number of selected Product again.");
            }
        }
    }
}

