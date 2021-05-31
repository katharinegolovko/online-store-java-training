package com.issoft.store.threads;

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
        try {
            Thread.sleep(100 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String purchasedName = product.getName();
        int purchasedRate = product.getRate();
        double purchasedPrice = product.getPrice();

        String SQL = "INSERT INTO PurchasedProducts(name, rate, price) VALUES (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            pstmt.setString(1, purchasedName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            pstmt.setInt(2, purchasedRate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            pstmt.setDouble(3, purchasedPrice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs1 = null;
        try {
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
            try {
                returnedName = rs1.getString("NAME");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            int returnedRate = 0;
            try {
                returnedRate = rs1.getInt("RATE");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            double returnedPrice = 0;
            try {
                returnedPrice = rs1.getDouble("PRICE");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("name=" + returnedName + ", rate=" + returnedRate + ", price= " + returnedPrice);
        }
    }
}
