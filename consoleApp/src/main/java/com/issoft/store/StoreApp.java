package com.issoft.store;
import com.issoft.store.commands.Command;
import com.issoft.store.commands.OrderCommand;
import com.issoft.store.commands.SortCommand;
import com.issoft.store.handlers.SortHandler;
import com.issoft.store.handlers.TopHandler;
import com.issoft.store.threads.CleanUpCollectionThread;
import com.issoft.store.threads.PurchaseGoodsThread;
import com.sun.net.httpserver.HttpServer;
import io.restassured.RestAssured;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

public class StoreApp {

    private static String URL = "http://localhost:3535";
    public static void main(String args[]) throws Exception {

        Server server = new Server();
        server.run();

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        Store store = Store.getInstance();
        store.setCategories(randomStorePopulator.populateProductLists());
        List<Product> extractedProducts = new ArrayList<>();
        for (Category category: store.getCategories()) {
            extractedProducts.addAll(category.getProducts());
        }

        CleanUpCollectionThread cleanUpCollectionThread = new CleanUpCollectionThread();
        cleanUpCollectionThread.start();


        int i = 1;
        while(i>=1){
            System.out.println("Hi! Available commands: sort, top, order and exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

        if(userCommand.equalsIgnoreCase("sort")) {
            get(URL + "/sort");
        }
        else if(userCommand.equalsIgnoreCase("top")){
            get(URL + "/top");
        }
        else if (userCommand.equalsIgnoreCase("order")){

            server.order();
            get(URL + "/order");
            }
        else if(userCommand.equalsIgnoreCase("exit")) {
                reader.close();
                server.stop();
                System.out.println("See you soon!");
                System.exit(0);
            }
            else {
                System.out.println("The command was not recognized. Available commands: sort, top, exit. Please try again.");
            }
        }
        }

    private static String get(String url) {
        System.out.println(URL);
        String response = RestAssured.given().when().get(url).body().prettyPrint();
        return response;
    }

}



