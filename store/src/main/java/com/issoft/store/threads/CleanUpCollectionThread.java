package com.issoft.store.threads;

import com.issoft.store.Store;


public class CleanUpCollectionThread extends Thread {

    public void run() {
        while (true) {
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           Store store = Store.getInstance();
            store.getPurchasedProducts().clear();
            System.out.println("Purchased Products Collection was cleaned: " + store.getPurchasedProducts().toString());
        }
    }
}
