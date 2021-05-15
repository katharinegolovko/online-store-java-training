package com.issoft.store.commands;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;
import com.issoft.store.threads.CleanUpCollectionThread;
import com.issoft.store.threads.PurchaseGoodsThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OrderCommand implements Command {

    private static List<Product> selectedProducts;

    @Override
    public void execute(List<Product> products) throws IOException {
        System.out.println("What Product do you want to buy? Please enter the number of the Product from the Product List. All available Products you can observe using Sort and Top commands.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userChoice = reader.readLine();
        int productIndex = Integer.parseInt(userChoice) - 1;
        List<Product> selectedProductsByUser = products.subList(productIndex, productIndex+1);
        setSelectedProducts(selectedProductsByUser);
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        System.out.println("The Product you selected is:");
        randomStorePopulator.prettyProducts(selectedProductsByUser);
        Thread purhaseGoodsThread = new PurchaseGoodsThread();
        purhaseGoodsThread.start();
        Thread cleanUpCollectionThread = new CleanUpCollectionThread();
        cleanUpCollectionThread.start();
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        OrderCommand.selectedProducts = selectedProducts;
    }

    public List<Product> getSelectedProducts(){
        return selectedProducts;
    }
}
