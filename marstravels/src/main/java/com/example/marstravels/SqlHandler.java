package com.example.marstravels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class SqlHandler {



    public class main {
        public static void main (String[]args){
            Connection conn = null;
            String connectionURL = "jdbc:mysql://localhost:3306/SUM7" + "autoReconnect=true&useSSL=false"; // url
            Properties properties = new Properties();
            String Username = "root"; // username
            String password = ""; // pw
            //properties.setProperty("useSSL", "false");


            try {
                conn = DriverManager.getConnection(connectionURL, Username, password);
                System.out.println(connectionURL);


                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from SUM7.Hytt"); // test query
                System.out.println(resultSet.getString("category")); // kolumnens namn
           /* while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
            }*/
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }
}
