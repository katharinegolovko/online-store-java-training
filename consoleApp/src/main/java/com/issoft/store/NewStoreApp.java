package com.issoft.store;

import com.issoft.store.refactoring.NewServer;
import io.restassured.RestAssured;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewStoreApp {
    private static String URL = "http://localhost:3535";

    public static void main(String args[]) throws Exception {

        NewServer server = new NewServer();
        server.run();

        int i = 1;
        while (i >= 1) {
            System.out.println("Hi! Available commands: sort, top, order and exit. Please enter your command: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userCommand = reader.readLine();

            if (userCommand.equalsIgnoreCase("sort")) {
                //TODO
                System.out.println("NOT IMPLEMENTED");
            } else if (userCommand.equalsIgnoreCase("top")) {
                get(URL + "/top");
            } else if (userCommand.equalsIgnoreCase("order")) {
                //TODO
                System.out.println("NOT IMPLEMENTED");
            } else if (userCommand.equalsIgnoreCase("exit")) {
                reader.close();
                server.stop();
                System.out.println("See you soon!");
                System.exit(0);
            } else {
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
