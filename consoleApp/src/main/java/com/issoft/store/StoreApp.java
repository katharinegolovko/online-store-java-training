package com.issoft.store;

import java.util.List;


public class StoreApp {


    public static void main(String args[]) throws IllegalAccessException {

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        Store store = new Store();
        store.setCategories(randomStorePopulator.populateProductLists());
        List<Category> extractedData = randomStorePopulator.extractDataFromStore(store);
        randomStorePopulator.pretty(extractedData);

    }


}



