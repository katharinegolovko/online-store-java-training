package com.issoft.store;
import java.util.Comparator;

public class ProductRateComparator implements Comparator<Product> {


    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XMLParser xmlParser = new XMLParser();

        switch (xmlParser.getElementByTagName("rate")) {
            case "desc":
                return Integer.compare(secondProduct.getRate(), firstProduct.getRate());
            default:
                return Integer.compare(firstProduct.getRate(), secondProduct.getRate());
        }
    }
}
