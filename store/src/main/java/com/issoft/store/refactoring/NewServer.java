package com.issoft.store.refactoring;

import com.issoft.store.RandomStorePopulator;
import com.issoft.store.Store;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NewServer {
    private Store store;
    HttpServer server;

    public void run() throws IOException {
        store = Store.getInstance();
        store.setCategories(new RandomStorePopulator().populateProductLists());

        server = HttpServer.create(new InetSocketAddress(3535), 0);
        server.createContext("/top", new Top5Handler());
        server.setExecutor(null); // creates a default executor
        server.start();

    }

    public void stop() {
        server.stop(2);
    }


}
