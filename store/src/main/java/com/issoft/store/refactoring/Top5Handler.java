package com.issoft.store.refactoring;

import com.issoft.store.Category;
import com.issoft.store.Product;
import com.issoft.store.ProductPriceComparator;
import com.issoft.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Top5Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Client connected to 'top5'");

        List<Product> extractedProducts = new ArrayList<>();
        for (Category category : Store.getInstance().getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }
        Collections.sort(extractedProducts, new ProductPriceComparator());
        List<Product> finalList = extractedProducts.subList(0, 5);

        String top5 = Product.productToString(finalList);
        final byte[] out = top5.getBytes("UTF-8");

        httpExchange.sendResponseHeaders(200, out.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(out);
        os.close();
    }
}
