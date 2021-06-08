package com.issoft.store.threads;

import com.issoft.store.DatabaseConnection;
import com.issoft.store.Product;

import java.sql.*;
import java.util.List;
import java.util.Random;

public class PurchaseGoodsThread extends Thread {

    private Product product;
    private List<Product> purchasedGoods;

    public PurchaseGoodsThread(Product selectedProduct) {
        this.product = selectedProduct;
    }

    public void setPurchasedGoods(List<Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public List<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void run() {
        int x = new Random().nextInt(30);
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().connectToDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PreparedStatement pstmt;
        ResultSet rs1 = null;

        try {
            Thread.sleep(100 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String purchasedName = product.getName();
        int purchasedRate = product.getRate();
        double purchasedPrice = product.getPrice();

        String SQL = "INSERT INTO PurchasedProducts(name, rate, price) VALUES (?, ?, ?)";

        try {
            Statement st = conn.createStatement();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, purchasedName);
            pstmt.setInt(2, purchasedRate);
            pstmt.setDouble(3, purchasedPrice);
            pstmt.executeUpdate();
            rs1 = st.executeQuery("SELECT * FROM PurchasedProducts");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Your purchased product(s) is(are): ");
        while (true) {
            try {
                if (!rs1.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            String returnedName = null;
            int returnedRate = 0;
            double returnedPrice = 0;
            try {
                returnedName = rs1.getString("NAME");
                returnedRate = rs1.getInt("RATE");
                returnedPrice = rs1.getDouble("PRICE");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("name=" + returnedName + ", rate=" + returnedRate + ", price= " + returnedPrice);
        }
    }
}
