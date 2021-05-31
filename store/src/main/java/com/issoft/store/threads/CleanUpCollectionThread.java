package com.issoft.store.threads;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CleanUpCollectionThread extends Thread {

    public void run() {
        while (true) {
            try {
                Thread.sleep(40000);
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
            String sql = "DELETE from PurchasedProducts";
            try {
                st.executeUpdate(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Purchased Products Collection was cleaned.");
        }
    }
}
