package com.issoft.store.handlers;

import com.issoft.store.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Client connected to 'sort'");
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category : Store.getInstance().getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }
        Comparator<Product> productComparator = new ProductNameComparator().thenComparing(new ProductRateComparator().thenComparing(new ProductPriceComparator()));
        Collections.sort(extractedProducts, productComparator);
        String sortedList = Product.productToString(extractedProducts);
        final byte[] out = sortedList.getBytes("UTF-8");

        httpExchange.sendResponseHeaders(200, out.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(out);
        os.close();
    }
}
