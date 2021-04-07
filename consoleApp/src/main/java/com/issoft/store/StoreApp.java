package com.issoft.store;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StoreApp {


    public static void main(String args[]) throws IllegalAccessException, IOException {

        int i = 1;
        while(i>=1){
            System.out.println("Hi! Enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

            if(userCommand.equalsIgnoreCase("sort")){
                RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
                Store store = new Store();
                store.setCategories(randomStorePopulator.populateProductLists());
                List<Category> extractedData = randomStorePopulator.extractDataFromStore(store);
                Collections.sort(extractedData, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
                randomStorePopulator.pretty(extractedData);
            } else if(userCommand.equalsIgnoreCase("exit")) {
                reader.close();
                System.out.println("See you soon!");
                i = 0;
            }
            else {
                System.out.println("The command was not recognized. Available commands: sort, top, exit. Please try again.");
            }
        }


        }








        //Collections.sort(extractedData, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        //System.out.println(extractedData);





}



