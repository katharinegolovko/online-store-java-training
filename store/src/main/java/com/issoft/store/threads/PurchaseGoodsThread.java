package com.issoft.store.threads;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;
import com.issoft.store.commands.OrderCommand;

import java.util.List;
import java.util.Random;

public class PurchaseGoodsThread extends Thread {
    public void run() {
        int i = new Random().nextInt(30);
        try {
            Thread.sleep(100*i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OrderCommand orderCommand = new OrderCommand();
        List<Product> purchasedGoods = orderCommand.getSelectedProducts();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        System.out.println("Your purchased product is:");
        randomStorePopulator.prettyProducts(purchasedGoods);
    }
}
