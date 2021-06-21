package com.issoft.store;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {

    public void run() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(3535), 0);
        server.createContext("/test", new MyHandler1());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private static final String USER_AGENT = "Chrome/91.0";

    private static final String GET_URL = "https://localhost:3535/purchasedcollection";


    public void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }

    public void postRequest(Product selectedProduct) throws IOException {
        Product product = selectedProduct;
        HttpServer server = HttpServer.create(new InetSocketAddress(3535), 0);
        server.createContext("/test", new MyHandler1());
        server.setExecutor(null);
        server.start();
        RestAssured.baseURI = "http://localhost:3535/test";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("ProductName", String.format("%s", product.getName()));
        requestParams.put("ProductPrice", String.format("%f", product.getPrice()));
        requestParams.put("ProductRate", String.format("%d", product.getRate()));
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post("/purchasedcollection");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "200");
    }


    class MyHandler1 implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

        }
    }


}
