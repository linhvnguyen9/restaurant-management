package com.ptit.restaurantmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantManagementDatabase {
    public static final String DATABASENAME = "testDb";
    public static final String USER = "root";
    public static final String PASS = "19091999";
    public static final String BASEURL = "jdbc:mysql://localhost:3306/" + DATABASENAME;

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
            createPersonTable(connection);
            createEmployeesTable(connection);
            createCustomerTable((connection));
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void createPersonTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS person (" +
                "id_person int auto_increment primary key not null,"+
                "name varchar(255) not null,"+
                "dob date,"+
                "addr varchar(255))";

        Statement statement = connection.createStatement();
        statement.execute(query);
    }
    private static void createEmployeesTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS employee" +
                "(id_employee int AUTO_INCREMENT, " +
                "type varchar(255) not null,"+
                "id_manager int ,"+
                "salary double not null, "+
                "primary key ( id_employee),"+
                "foreign key (id_manager) references employee(id_employee),"+
                "foreign key (id_employee) references person(id_person))";

        Statement statement = connection.createStatement();
        statement.execute(query);
    }
    private static void createCustomerTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS customer"+
                "(id_customer int not null,"+
                "type varchar(255) not null,"+
                "primary key(id_customer),"+
                "foreign key (id_customer) references person(id_person))";

        Statement statement = connection.createStatement();
        statement.execute(query);
    }
    public static void main(String[] args) {
        getConnection();
    }
}
