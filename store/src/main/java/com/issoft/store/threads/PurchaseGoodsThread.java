package com.issoft.store.threads;

import com.issoft.store.Product;
import com.issoft.store.Store;

import java.util.List;
import java.util.Random;

public class PurchaseGoodsThread extends Thread {

    private Product product;
    private List<Product> purchasedGoods;

    public PurchaseGoodsThread(Product selectedProduct) {
        this.product = selectedProduct;
    }

    public void setPurchasedGoods(List<Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public List<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void run() {
        int x = new Random().nextInt(30);
        try {
            Thread.sleep(100*x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Store store = Store.getInstance();
        store.getPurchasedProducts().add(product);
        System.out.println("Your purchased product(s) is(are): " + store.getPurchasedProducts().toString());

    }
}
