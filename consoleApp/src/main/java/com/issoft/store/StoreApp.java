package com.issoft.store;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.issoft.store.TestConstants.FRUIT;


public class StoreApp {


    public static void main(String args[]) throws IllegalAccessException, IOException {

        int i = 1;
        while(i>=1){
            System.out.println("Hi! Available commands: sort, top, exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();
            RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
            Store store = new Store();
            store.setCategories(randomStorePopulator.populateProductLists());
            List<Category> extractedData = randomStorePopulator.extractDataFromStore(store);
            //Category category1 = extractedData.get(0);
            //Category category2 = extractedData.get(1);
            //Category category3 = extractedData.get(2);
            //List<Product> extractedProducts = randomStorePopulator.extractDataFromCategory(category1);
            //System.out.println(extractedProducts);


            //List<Product> extractedProducts1 = category1.getProducts();
            //List<Product> extractedProducts2 = category2.getProducts();
            //List<Product> extractedProducts3 = category3.getProducts();

            //Stream<Product> combinedStream = Stream.concat(
            //        Stream.concat(extractedProducts1.stream(), extractedProducts2.stream()),
            //       extractedProducts3.stream());
            //System.out.println(combinedStream.toString());

            //System.out.println(extractedProducts);
           // ProductRateComparator productRateComparator = new ProductRateComparator();
            //Collections.sort(extractedProducts, productRateComparator);
           // randomStorePopulator.pretty(extractedData);





        if(userCommand.equalsIgnoreCase("sort")){



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



