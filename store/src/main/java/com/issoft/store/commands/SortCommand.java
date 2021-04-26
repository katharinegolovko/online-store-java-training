package com.issoft.store.commands;

import com.issoft.store.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand implements Command{

    @Override
    public void execute(List<Product> extractedProducts){
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        Comparator<Product> productComparator = new ProductNameComparator().thenComparing(new ProductRateComparator().thenComparing(new ProductPriceComparator()));
        Collections.sort(extractedProducts, productComparator);
        randomStorePopulator.prettyProducts(extractedProducts);
    }
}
