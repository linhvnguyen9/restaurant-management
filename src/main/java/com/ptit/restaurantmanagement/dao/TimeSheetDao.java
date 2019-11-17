package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.TimeSheet;

import java.sql.*;
import java.util.ArrayList;

public class TimeSheetDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    private PersonDao personDao = new PersonDao();
    ArrayList<TimeSheet> listTimeSheet = new ArrayList<>();

    public TimeSheetDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public void insertTimeSheet(TimeSheet timeSheet) throws SQLException {
        String createTimeSheet = "INSERT INTO timesheet VALUES(?, ?, ?, ? )";
        PreparedStatement preparedStatement = stament.prepareStatement(createTimeSheet);

        preparedStatement.setInt(1,timeSheet.getEmployeeId());
        preparedStatement.setInt(2, timeSheet.getMonth());
        preparedStatement.setInt(3, timeSheet.getYear());
        preparedStatement.setInt(4, timeSheet.getWorkdays());
        preparedStatement.executeUpdate();
    }
    public ArrayList<TimeSheet> getListTimeSheet(int idEmployee) throws SQLException  {
        String sql = "SELECT * FROM timesheet WHERE id_employee=?;";
        PreparedStatement preparedStatement = stament.prepareStatement(sql);
        preparedStatement.setInt(1,idEmployee);

        try {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                listTimeSheet.add(timeSheetFromResultSet(rs));
            }
            for (int i=0;i<listTimeSheet.size();i++)
                System.out.println(listTimeSheet.get(i).toString());
            return listTimeSheet;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void updateTimesheet(int id,int workdays) throws SQLException {
        String updateEmployees = "UPDATE timesheet set workdays=? WHERE id_employee=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setInt(1, workdays);
        pstmt.setInt(2, id);
        System.out.println(pstmt.toString());
        pstmt.executeUpdate();
    }

    public void deleteTimeSheet(int idEmployee,int month,int year) throws SQLException {
        String deleteTimesheet = "delete from timesheet where id_employee=? and month=? and year=? ;";
        PreparedStatement pstmt = stament.prepareStatement(deleteTimesheet);
        pstmt.setInt(1,idEmployee);
        pstmt.setInt(2,month);
        pstmt.setInt(3,year);
        pstmt.executeUpdate();
    }

    private TimeSheet timeSheetFromResultSet(ResultSet rs) throws SQLException {
        int employeeId = rs.getInt("id_employee");
        int month=rs.getInt("month");
        int year=rs.getInt("year");
        int workdays=rs.getInt("workdays");
        return new TimeSheet(employeeId,month,year,workdays);
    }
}
