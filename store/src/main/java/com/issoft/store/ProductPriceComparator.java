package com.issoft.store;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
    }
}
