package com.issoft.store.threads;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;

import java.util.List;
import java.util.Random;

public class PurchaseGoodsThread extends Thread {

    private List<Product> productsForPurchase;
    private List<Product> purchasedGoods;

    public PurchaseGoodsThread(List<Product> selectedProducts) {
        this.productsForPurchase = selectedProducts;
    }

    public void setPurchasedGoods(List<Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public List<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void run() {
        int i = new Random().nextInt(30);
        try {
            Thread.sleep(100*i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        purchasedGoods.addAll(productsForPurchase);
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        System.out.println("Your purchased product is:");
        randomStorePopulator.prettyProducts(purchasedGoods);
    }
}
