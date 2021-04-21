package com.issoft.store;
import java.util.*;

public final class Printer {

    private static Printer instance;

    private Printer(){
    }

    public static Printer getInstance(){
        if (instance == null){
            instance = new Printer();
        }
        return instance;
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

