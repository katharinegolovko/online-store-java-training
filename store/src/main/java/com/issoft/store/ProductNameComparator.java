package com.issoft.store;
import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {
    private static ProductNameComparator instance;
    private ProductNameComparator(){
    }
    public static ProductNameComparator getInstance(){
        if (instance == null){
            instance = new ProductNameComparator();
        }
        return instance;
    }

    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        XMLParser xmlParser = new XMLParser();

        switch (xmlParser.getElementByTagName("name")) {
            case "desc":
                return secondProduct.getName().compareTo(firstProduct.getName());
            default:
                return firstProduct.getName().compareTo(secondProduct.getName());
        }
    }
}
