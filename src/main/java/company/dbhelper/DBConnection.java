package company.dbhelper;

import java.sql.*;

public class DBConnection {

    //create one static method to return the connection to DB via the JDBC.
    //It is static because we don't need multiple connections or instances to DB, we need one.

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "portfolio2017");
            if (connection != null) System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There was a problem connection to the DB.");
        }
        return connection;
    }

}
