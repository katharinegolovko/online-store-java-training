package com.issoft.store;

import java.io.*;
import java.net.InetSocketAddress;

import com.issoft.store.handlers.OrderHandler;
import com.issoft.store.handlers.SortHandler;
import com.issoft.store.handlers.TopHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {


        private Store store;
        HttpServer server;

        public void run() throws IOException {
            store = Store.getInstance();
            store.setCategories(new RandomStorePopulator().populateProductLists());

            server = HttpServer.create(new InetSocketAddress(3535), 0);
            server.createContext("/top", new TopHandler());
            server.createContext("/sort", new SortHandler());
            server.createContext("/order", new OrderHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
        }

        public void stop() {
            server.stop(2);
        }

        public void order() throws IOException {
        store = Store.getInstance();
        server.createContext("/order", new OrderHandler());
    }

    }

