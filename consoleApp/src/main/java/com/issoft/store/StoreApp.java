package com.issoft.store;

import org.reflections.Reflections;
import java.util.ArrayList;


public class StoreApp {

    public static void main(String args[]){

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        ArrayList<Category> categoryList = randomStorePopulator.populateProductLists();
        String output = categoryList.toString().replaceAll("(^\\[|\\]$)", "");
        System.out.println(output);

        Reflections reflections = new Reflections("my.package");

        }
    }


