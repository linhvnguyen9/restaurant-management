package com.ptit.restaurantmanager.database;

import com.ptit.restaurantmanagement.dao.MenuEntryDao;
import com.ptit.restaurantmanagement.domain.model.MenuEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Calendar;

public class MenuEntryDaoTest {
    private static MenuEntryDao dao;

    @BeforeAll
    public static void init() {
        try {
            dao = new MenuEntryDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertMenuEntryDao() {
        MenuEntry menuEntry = new MenuEntry("Thuoc", 10000);
        try {
            dao.insertMenuEntry(menuEntry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getListMenuEntry() {
        dao.getListMenuEntry();
    }
    @Test
    public void searchMenuEntry() {
        try {
            System.out.println(dao.searchListMenuEntry(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void UpdateMenuEntry() {
        MenuEntry menuEntry = new MenuEntry("Update2222", 99999);
        try {
            dao.updateMenuEntry(menuEntry,2);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteMenuEntry() {
        try {
            dao.deleteMenuEntry(3);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
