package p1;

/*
 * Created by emailman on 4/12/2016.
 */

import java.sql.*;

public class CIS150DB_Demo {
    public static void main(String[] args) {

        // Strings to connect to database
        String url = "//phpmyadmin.cdgwdgkn5fuv.us-west-2.rds.amazonaws.com";
        String db_name = "eric_db";
        String user = "db_eric";
        String password = "Way2Go";
        String connect = "jdbc:mysql:" + url + ":3306/" + db_name;

        Connection connection = null;

        // Load the mysql driver
        try {Class.forName("com.mysql.jdbc.Driver");
            // System.out.println("Driver Loaded");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Driver not loaded");
        }

        // Connect to the database
        try {
            connection =
                    DriverManager.getConnection(connect, user, password);
            // System.out.println("Connection Successful");
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println("Connection not successful");
        }

        // Get information from the database
        try (Statement s = connection.createStatement()) {
            ResultSet rs = s.executeQuery("SELECT * FROM address");

            // Display the record set
            while (rs.next()) {
                System.out.println(rs.getString(1) +
                    " lives in apartment " + rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }
    }
}
