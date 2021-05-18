package com.issoft.store.threads;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;

import java.util.ArrayList;
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
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        setPurchasedGoods(productList);
    }
}
