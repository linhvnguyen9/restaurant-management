package com.ptit.restaurantmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantManagementDatabase {
    public static final String BASEURL = "jdbc:mysql://localhost:3306/";
    public static final String DATABASENAME = "testDb";
    public static final String USER = "root";
    public static final String PASS = "";

    public static void createDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createDatabase = "CREATE DATABASE IF NOT EXISTS " + DATABASENAME;
        statement.execute(createDatabase);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(BASEURL, USER, PASS);
            createDatabase(connection);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
