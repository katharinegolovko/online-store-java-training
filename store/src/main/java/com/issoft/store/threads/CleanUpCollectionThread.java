package com.issoft.store.threads;
import com.issoft.store.DatabaseConnection;

import java.sql.Connection;
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
            Connection conn = null;
            Statement st = null;
            String sql = "DELETE from PurchasedProducts";
            try {
                conn = DatabaseConnection.getInstance().connectToDatabase();
                st = conn.createStatement();
                st.executeUpdate(sql);
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Purchased Products Collection was cleaned.");

        }
    }
}
