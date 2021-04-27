package com.issoft.store;
import com.issoft.store.commands.Command;
import com.issoft.store.commands.SortCommand;
import com.issoft.store.commands.TopCommand;

import java.io.*;
import java.util.*;



public class StoreApp {


    public static void main(String args[]) throws IOException {


        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        Store store = Store.getInstance();
        store.setCategories(randomStorePopulator.populateProductLists());
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category: store.getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }

        int i = 1;
        while(i>=1){
            System.out.println("Hi! Available commands: sort, top, exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

        if(userCommand.equalsIgnoreCase("sort")) {

        Command sortCommand = new SortCommand();
        sortCommand.execute(extractedProducts);

        }
        else if(userCommand.equalsIgnoreCase("top")){

            Command topCommand = new TopCommand();
            topCommand.execute(extractedProducts);
        }
        else if(userCommand.equalsIgnoreCase("exit")) {
                reader.close();
                System.out.println("See you soon!");
                i = 0;
            }
            else {
                System.out.println("The command was not recognized. Available commands: sort, top, exit. Please try again.");
            }
        }
        }
}



