package com.ptit.restaurantmanagement.dao;

import com.ptit.restaurantmanagement.database.RestaurantManagementDatabase;
import com.ptit.restaurantmanagement.domain.model.MenuEntry;


import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MenuEntryDao {
    private Statement statement;
    private Connection stament = RestaurantManagementDatabase.getConnection();
    ArrayList<MenuEntry> listMenuEntry = new ArrayList<>();

    public MenuEntryDao() throws SQLException {
        RestaurantManagementDatabase.createDatabase(stament);
        RestaurantManagementDatabase.getConnection();
    }

    public int insertMenuEntry(MenuEntry menuEntry) throws SQLException {
        String insertMenuEntry = "INSERT INTO menu_entry VALUES (0, ?, ?)";

        PreparedStatement preparedStatement = stament.prepareStatement(insertMenuEntry, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, menuEntry.getName());
        preparedStatement.setDouble(2, menuEntry.getPrice());

        int menu_entry_id = preparedStatement.executeUpdate();
        if (menu_entry_id != -1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                menu_entry_id = resultSet.getInt(1);
            }
        } else {
            throw new SQLException();
        }
        return menu_entry_id;
    }

    public ArrayList<MenuEntry> getListMenuEntry() {
        String sql = "SELECT * FROM menu_entry;";

        try {
            PreparedStatement ps = stament.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = (rs.getInt("id_menu_entry"));
                String name = (rs.getString("name"));
                double price = rs.getDouble("price");
                MenuEntry s = new MenuEntry(id, name, price);
                listMenuEntry.add(s);
            }
            for (int i = 0; i < listMenuEntry.size(); i++)
                System.out.println(listMenuEntry.get(i).toString());
            return listMenuEntry;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print out listEmployee

        return new ArrayList<>();
    }

    public void updateMenuEntry(MenuEntry menuEntry, int id) throws SQLException {
        String updateEmployees = "UPDATE menu_entry SET name=?,price=? WHERE id_menu_entry=?;";
        PreparedStatement pstmt = stament.prepareStatement(updateEmployees);

        pstmt.setString(1,menuEntry.getName() );
        pstmt.setDouble(2, menuEntry.getPrice());
        pstmt.setInt(3, id);
        System.out.println(pstmt.toString());
        pstmt.executeUpdate();
    }

    public void deleteMenuEntry(int id) throws SQLException {
        String deleteMenuEntry = "delete from menu_entry where id_menu_entry=?;";
        PreparedStatement pstmMenuEntry = stament.prepareStatement(deleteMenuEntry);
        pstmMenuEntry.setInt(1, id);
        pstmMenuEntry.executeUpdate();
    }

    public MenuEntry searchListMenuEntry(int id) throws SQLException {
        String search = "select * from menu_entry where id_menu_entry=?;";
        PreparedStatement pstmMenuEntry = stament.prepareStatement(search);
        pstmMenuEntry.setInt(1, id);

        ResultSet rs = pstmMenuEntry.executeQuery();
        rs.next();
        int idMenuEtry = (rs.getInt("id_menu_entry"));
        String name = (rs.getString("name"));
        double price = rs.getDouble("price");
        return new MenuEntry(idMenuEtry, name, price);
    }
}
