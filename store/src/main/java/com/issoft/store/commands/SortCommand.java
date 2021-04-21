package com.issoft.store.commands;

import com.issoft.store.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand implements Command{

    private static SortCommand instance;
    private SortCommand(){
    }
    public static SortCommand getInstance(){
        if (instance == null){
            instance = new SortCommand();
        }
        return instance;
    }

    @Override
    public void execute(List<Product> extractedProducts){
        Printer printer = Printer.getInstance();
        Comparator<Product> productComparator = ProductNameComparator.getInstance().thenComparing(ProductRateComparator.getInstance().thenComparing(ProductPriceComparator.getInstance()));
        Collections.sort(extractedProducts, productComparator);
        printer.prettyProducts(extractedProducts);
    }
}
