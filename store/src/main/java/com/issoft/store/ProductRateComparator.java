package com.issoft.store;

import java.util.Comparator;

public class ProductRateComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return Integer.compare(firstProduct.getRate(), secondProduct.getRate());
    }
}
