package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class TimesheetDao {
    private Connection connection = RestaurantManagementDatabase.getConnection();

    public TimesheetDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(connection);
        RestaurantManagementDatabase.getConnection();
    }


}
