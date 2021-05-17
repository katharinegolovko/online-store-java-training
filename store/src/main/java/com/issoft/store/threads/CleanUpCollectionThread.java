package com.issoft.store.threads;

import com.issoft.store.Product;
import com.issoft.store.commands.OrderCommand;

import java.util.List;

public class CleanUpCollectionThread extends Thread {

    private List<Product> productsForCleanUp;

    public CleanUpCollectionThread (List<Product> products){
        this.productsForCleanUp = products;
    }

    public void run() {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsForCleanUp.clear();
    }
}
