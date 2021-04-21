package com.issoft.store;
import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    private static ProductPriceComparator instance;
    private ProductPriceComparator(){
    }
    public static ProductPriceComparator getInstance(){
        if (instance == null){
            instance = new ProductPriceComparator();
        }
        return instance;
    }

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
