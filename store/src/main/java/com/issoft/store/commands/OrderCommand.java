package com.issoft.store.commands;

import com.issoft.store.Product;
import com.issoft.store.RandomStorePopulator;
import com.issoft.store.threads.CleanUpCollectionThread;
import com.issoft.store.threads.PurchaseGoodsThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OrderCommand implements Command {

    private List<Product> testProductList;

    public OrderCommand(List<Product> products){
       this.testProductList = products;
    }

    public List<Product> getSelectedProducts() {
        return testProductList;
    }

    public void setSelectedProducts(List<Product> selectedProduct) {
        this.testProductList = selectedProduct;
    }

    @Override
    public void execute(List<Product> products) throws IOException {
        System.out.println("What Product do you want to buy? Please enter the number of the Product from the Product List. All available Products you can observe using Sort and Top commands.");
        int i = 1;
        while (i >= 1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userChoice = reader.readLine();
            int productIndex = Integer.parseInt(userChoice) - 1;
            int listSize = products.size() - 1;

            if(productIndex>=0) {
                if (productIndex <= listSize) {
                    Product selectedProductsByUser = products.get(productIndex);
                    RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
                    System.out.println("The Product you selected is:");
                    randomStorePopulator.prettyProduct(selectedProductsByUser);
                    List<Product> productsList = new ArrayList<>();
                    productsList.add(selectedProductsByUser);
                    setSelectedProducts(productsList);
                    Thread purhaseGoodsThread = new PurchaseGoodsThread(getSelectedProducts());
                    purhaseGoodsThread.start();
                    i = 0;
                } else {
                    System.out.println("You have entered incorrect number of Product. Please check Products in the Product List and enter number of selected Product again.");
                }
            }
            else{
                System.out.println("You have entered incorrect number of Product. Please check Products in the Product List and enter number of selected Product again.");
            }
        }
    }

}
