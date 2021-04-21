package com.issoft.store.commands;

import com.issoft.store.*;

import java.util.Collections;
import java.util.List;

public class TopCommand implements Command {

    private static TopCommand instance;
    private TopCommand(){
    }
    public static TopCommand getInstance(){
        if (instance == null){
            instance = new TopCommand();
        }
        return instance;
    }

    @Override
    public void execute(List<Product> extractedProducts){
        Printer printer = Printer.getInstance();
        ProductPriceComparator productPriceComparator = ProductPriceComparator.getInstance();
        Collections.sort(extractedProducts, productPriceComparator);
        List<Product> finalList = extractedProducts.subList(0, 5);
        printer.prettyProducts(finalList);
    }
}
