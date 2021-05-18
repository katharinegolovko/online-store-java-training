package com.issoft.store.threads;

import com.issoft.store.Product;

import java.util.List;

public class CleanUpCollectionThread extends Thread {

    private List<Product> productsForCleanUp;

    public CleanUpCollectionThread (List<Product> purchasedProducts){
        this.productsForCleanUp = purchasedProducts;
    }

    public List<Product> getProductsForCleanUp() {
        return productsForCleanUp;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productsForCleanUp.clear();
        }
    }
}
