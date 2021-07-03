package com.issoft.store.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderHandler implements HttpHandler {
    int productNumber = 0;
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("Client connected to 'order'");
        Map<String, String> params = queryToMap(httpExchange.getRequestURI().getQuery());
        if (params != null) {
            productNumber = Integer.parseInt(params.get("productNumber"));
        }
    }

    private Map<String, String> queryToMap(String query) {
        if(query == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }else{
                result.put(entry[0], "");
            }
        }
        return result;
    }
    }

