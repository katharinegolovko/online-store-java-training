package com.issoft.store;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import sun.plugin.dom.html.ns4.NS4DOMObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {

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

        if(doc.getElementsByTagName("price").item(0).getTextContent().equalsIgnoreCase("asc")){
            return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
        }
        else if(doc.getElementsByTagName("price").item(0).getTextContent().equalsIgnoreCase("desc")){
            return Double.compare(secondProduct.getPrice(), firstProduct.getPrice());
        }
        else {
            return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
        }

    }
}
