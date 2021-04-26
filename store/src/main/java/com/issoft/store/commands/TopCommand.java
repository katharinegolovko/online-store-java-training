package com.issoft.store.commands;

import com.issoft.store.Product;
import com.issoft.store.ProductPriceComparator;
import com.issoft.store.RandomStorePopulator;

import java.util.Collections;
import java.util.List;

public class TopCommand implements Command {

    @Override
    public void execute(List<Product> extractedProducts) {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        ProductPriceComparator productPriceComparator = new ProductPriceComparator();
        Collections.sort(extractedProducts, productPriceComparator);
        List<Product> finalList = extractedProducts.subList(0, 5);
        randomStorePopulator.prettyProducts(finalList);
    }
}
