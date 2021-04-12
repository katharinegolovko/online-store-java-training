package com.issoft.store;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product>{

    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        File file = new File("C:\\Users\\katyagolovko\\OnlineStoreJavaTraining\\consoleApp\\src\\main\\resources\\store.xml");
        DocumentBuilderFactory dbfaFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = dbfaFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(doc.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("asc")){
            return firstProduct.getName().compareTo(secondProduct.getName());
        }
        else if(doc.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("desc")){
            return secondProduct.getName().compareTo(firstProduct.getName());
        }
        else {
            return firstProduct.getName().compareTo(secondProduct.getName());
        }
    }
}
