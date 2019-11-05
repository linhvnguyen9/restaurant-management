package com.ptit.restaurantmanager.database;

import com.ptit.restaurantmanagement.dao.TimeSheetDao;
import com.ptit.restaurantmanagement.domain.model.TimeSheet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Calendar;

public class TimeSheetTest {
    private static TimeSheetDao dao;

    @BeforeAll
    public static void init() {
        try {
            dao = new TimeSheetDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTimeSheet() {
        TimeSheet timeSheet = new TimeSheet(3,6,2018,30);
        try {
            dao.insertTimeSheet(timeSheet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getListTimeSheet() {

        try {
            dao.getListTimeSheet(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void updateTimeSheet() {
        try {
            dao.updateTimesheet(1,30);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTimeSheet() {
        try {
            dao.deleteTimeSheet(2,5,2018);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
