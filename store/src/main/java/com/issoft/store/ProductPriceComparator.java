package com.issoft.store;
import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XMLParser xmlParser = new XMLParser();

        switch (xmlParser.getElementByTagName("price")) {
            case "desc":
                return Double.compare(secondProduct.getPrice(), firstProduct.getPrice());
            default:
                return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
        }
    }
}
